package com.instituto.galton.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.instituto.galton.dtos.EmailDTO;
import com.instituto.galton.dtos.LoginDTO;
import com.instituto.galton.dtos.PasswordRecoveryDTO;
import com.instituto.galton.dtos.RegistroDTO;
import com.instituto.galton.helpers.Alert;
import com.instituto.galton.models.DetalleDominio;
import com.instituto.galton.models.DetalleUsuario;
import com.instituto.galton.models.Usuario;
import com.instituto.galton.services.DetalleDominioService;
import com.instituto.galton.services.DetalleUsuarioService;
import com.instituto.galton.services.EmailServiceImp;
import com.instituto.galton.services.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DetalleUsuarioService detalleUsuarioService;
	
	@Autowired
    private EmailServiceImp emailService;
	
	@Autowired
	private DetalleDominioService detalleDominioService;
	
	@GetMapping("/login")
	public ModelAndView loginPage(@ModelAttribute(name = "alert", binding = false) Alert alert) {
		
		ModelAndView mv = new ModelAndView();
		
		if(alert.getText() != null) {
			mv.addObject("alert", alert);
		}
		
		mv.addObject("registroDTO", new RegistroDTO());
		mv.addObject("loginDTO", new LoginDTO());
        mv.setViewName("login");
        
		return mv;
	}
	
	@PostMapping("/register")
	@ResponseBody
	public Alert crearUsuario(@ModelAttribute("registroDTO") RegistroDTO registroDTO) {
		
		Alert alert = new Alert();
		
		Usuario usuario = new Usuario();
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword(registroDTO.getPassword());
		usuario.setRol("2");
		usuario.setEstado("A");
		usuario.setFechaCreacion(new Date());
		usuario.setFechaModificacion(new Date());
		
		try {
			if(!usuarioService.validarCorreo(registroDTO.getEmail())) {
				if (!detalleUsuarioService.validarDocumento(Integer.parseInt(registroDTO.getDocumento()))) {
					usuarioService.crearUsuario(usuario);
					System.out.println(registroDTO.toString());
					
					
					if(usuario.getId() > 0) {
						
						DetalleUsuario detalleUsuario = new DetalleUsuario();
						detalleUsuario.setIdUsuario(usuario.getId());
						detalleUsuario.setDocumento(Long.valueOf(registroDTO.getDocumento()));
						detalleUsuario.setNombre(registroDTO.getNombre());
						
						detalleUsuarioService.crearDetalleUsuario(detalleUsuario);
						System.out.println(detalleUsuario.toString());
						
						alert.setTitle("Registro de Usuario");
						alert.setText("El usuario ha sido registrado existosamente.");
						alert.setIcon("success");
						
					}
				}else {
					alert.setTitle("Registro de Usuario");
					alert.setText("El número de documento ingresado ya tiene asignado un correo electrónico, por favor, inicie sessión.");
					alert.setIcon("error");
				}
			}else {
				alert.setTitle("Registro de Usuario");
				alert.setText("El correo electrónico ya esta registrado, por favor, inicie sessión.");
				alert.setIcon("error");
			}
		}catch (Exception e){
			
			alert.setTitle("Registro de Usuario");
			alert.setText("Error en el registro de usuario: " + e.getMessage());
			alert.setIcon("error");
		}
		
		
		return alert;
	}
	
//	@PostMapping("/login")
//	@ResponseBody
//	public Alert iniciarSession(@ModelAttribute("registroDTO") LoginDTO loginDTO ) {
//		
//		Alert alert = new Alert();
//		
//		if(usuarioService.validarCorreo(loginDTO.getUsuario())) {
//			if (usuarioService.validarInicioSession(loginDTO.getUsuario(), loginDTO.getPassword())) {
//				alert.setIcon("success");
//			}else{
//				alert.setTitle("Inicio de Sessión");
//				alert.setText("Contraseña incorrecta, por favor, valide he intente de nuevo.");
//				alert.setIcon("error");
//			};
//		}else{
//			alert.setTitle("Inicio de Sessión");
//			alert.setText("El correo ingresado no existe.");
//			alert.setIcon("error");
//		};
//		
//		return alert;
//	}
//	
	
	@PostMapping("/login")
	public ModelAndView iniciarSession(@ModelAttribute("loginDTO") LoginDTO loginDTO, RedirectAttributes redirectAttributes) {
	    ModelAndView modelAndView = new ModelAndView();

	    if(usuarioService.validarCorreo(loginDTO.getUsuario())) {
	        if (usuarioService.validarInicioSession(loginDTO.getUsuario(), loginDTO.getPassword())) {
	        	redirectAttributes.addFlashAttribute("emailUsuario", loginDTO.getUsuario());
	            modelAndView.setViewName("redirect:/");
	        } else {
	            Alert alert = new Alert();
	            alert.setTitle("Inicio de Sesión");
	            alert.setText("Contraseña incorrecta, por favor, valide e intente de nuevo.");
	            alert.setIcon("error");
	            redirectAttributes.addFlashAttribute("alert", alert);
	            modelAndView.setViewName("redirect:/login");
	        }
	    } else {
	        Alert alert = new Alert();
	        alert.setTitle("Inicio de Sesión");
	        alert.setText("El correo ingresado no existe.");
	        alert.setIcon("error");
	        //modelAndView.addObject("alert", alert);
	        redirectAttributes.addFlashAttribute("alert", alert);
	        modelAndView.setViewName("redirect:/login");
	    }

	    return modelAndView;
	}
	
	@PostMapping("/requestPassword")
	@ResponseBody
	public Alert solicitarContrasena(@ModelAttribute("PasswordRecoveryDTO") PasswordRecoveryDTO passwordRecoveryDTO) {
		
		Alert alert = new Alert();
		DetalleDominio detalleDominio = detalleDominioService.consultaDominio("EMAIL", "MENSAJE_DE_CORREO");

		if(usuarioService.validarCorreo(passwordRecoveryDTO.getEmailModal())) {
			
			Usuario usuario = usuarioService.buscarUsuarioPorCorreo(passwordRecoveryDTO.getEmailModal());
			DetalleUsuario detalleUsuario = detalleUsuarioService.extraerDetallesUsuarioPorIdUsuario(usuario.getId());
			
			String textoEmail = detalleDominio.getValorDetalle().replace("#password", usuario.getPassword()) ;
			textoEmail = textoEmail.replace("#UserName", detalleUsuario.getNombre());
			
			EmailDTO emailDTO = new EmailDTO();
			emailDTO.setEmailTo(passwordRecoveryDTO.getEmailModal());
			emailDTO.setEmailSubject("Recuperación de Contraseña");
			emailDTO.setEmailText(textoEmail);
			emailService.sendSimpleMessage(emailDTO);
			
			alert.setTitle("Recuperación de Contraseña");
			alert.setText("Se ha enviado tu contraseña correctamente a tu correo electrónico");
			alert.setIcon("success");
			
		}else {
			alert.setTitle("Recuperación de Contraseña");
			alert.setText("El correo ingresado no existe.");
			alert.setIcon("error");
		}
		
		return alert;

	}
	
	@GetMapping("/logout")
	public ModelAndView finalizarSession() {
		
		ModelAndView mv = new ModelAndView();

        mv.setViewName("redirect:/login");
        
		return mv;
	}
}

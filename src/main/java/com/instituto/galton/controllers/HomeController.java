package com.instituto.galton.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instituto.galton.dtos.RegistroDTO;
import com.instituto.galton.helpers.Alert;
import com.instituto.galton.models.DetalleUsuario;
import com.instituto.galton.models.Usuario;
import com.instituto.galton.services.DetalleUsuarioService;
import com.instituto.galton.services.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DetalleUsuarioService detalleUsuarioService;
	
	@GetMapping("/")
	public String dashboardPage() {
		return "inicio";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("registroDTO", new RegistroDTO());
		return "login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public Alert crearUsuario(@ModelAttribute("registroDTO") RegistroDTO registroDTO, Model model) {
		
		Alert alert = new Alert();
		
		Usuario usuario = new Usuario();
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword(registroDTO.getPassword());
		usuario.setRol("2");
		usuario.setEstado("A");
		usuario.setFechaCreacion(new Date());
		usuario.setFechaModificacion(new Date());
		
		try {
			
			usuarioService.crearUsuario(usuario);
			System.out.println(registroDTO.toString());

		}catch (Exception e){
			
			alert.setTitle("Registro de Usuario");
			alert.setText("Error en el registro de usuario: " + e.getMessage());
			alert.setIcon("error");
		}
		
		if(usuario.getId() > 0) {
			DetalleUsuario detalleUsuario = new DetalleUsuario();
			detalleUsuario.setId_usuario(usuario.getId());
			detalleUsuario.setDocumento(Integer.parseInt(registroDTO.getDocumento()));
			detalleUsuario.setNombre(registroDTO.getNombre());
			
			try {
				detalleUsuarioService.crearDetalleUsuario(detalleUsuario);
				System.out.println(detalleUsuario.toString());
				
				alert.setTitle("Registro de Usuario");
				alert.setText("El usuario ha sido registrado existosamente");
				alert.setIcon("success");
				
			}catch(Exception e) {
				
				alert.setTitle("Registro de Usuario");
				alert.setText("Error en el registro de usuario: " + e.getMessage());
				alert.setIcon("error");
			}
		}
		return alert;
	}
	
	@GetMapping("/reportes")
	public String reportesPage() {
		return "reportes";
	}
}

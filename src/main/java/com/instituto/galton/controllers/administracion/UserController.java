package com.instituto.galton.controllers.administracion;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.instituto.galton.dtos.ActualizarUsuarioDTO;
import com.instituto.galton.dtos.CrearUsuarioDTO;
import com.instituto.galton.helpers.Alert;
import com.instituto.galton.helpers.FechaConverter;
import com.instituto.galton.models.DetalleUsuario;
import com.instituto.galton.models.Usuario;
import com.instituto.galton.services.DetalleUsuarioService;
import com.instituto.galton.services.UsuarioService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DetalleUsuarioService detalleUsuarioService;
	
	private ActualizarUsuarioDTO actualizarUsuarioDTO = null;
	
	@PostMapping("/crearUsuario")
	@ResponseBody
	public ResponseEntity<Object> creaUsuarioModal(@ModelAttribute("crearUsuarioDTO") CrearUsuarioDTO crearUsuarioDTO, Model model) {
		
		Alert alert = new Alert();
		alert.setIcon("success");
		alert.setText("registro exitoso desde crearUsuario");
		
		System.out.println("crearUsuarioDTO.getDocumentoUsuario(): "+crearUsuarioDTO.getDocumentoUsuario());
		System.out.println("crearUsuarioDTO.getDireccionUsuario(): "+crearUsuarioDTO.getDireccionUsuario());
		System.out.println("crearUsuarioDTO.getEmailUsuario(): "+crearUsuarioDTO.getEmailUsuario());
		System.out.println("crearUsuarioDTO.getEstadoUsuario(): "+crearUsuarioDTO.getEstadoUsuario());
		System.out.println("crearUsuarioDTO.getFechaNacimiento(): "+crearUsuarioDTO.getFechaNacimiento());
		System.out.println("crearUsuarioDTO.getNombreUsuario(): "+crearUsuarioDTO.getNombreUsuario());
		System.out.println("crearUsuarioDTO.getPasswordUsuario(): "+crearUsuarioDTO.getPasswordUsuario());
		System.out.println("crearUsuarioDTO.getRolUsuario(): "+crearUsuarioDTO.getRolUsuario());
		System.out.println("crearUsuarioDTO.getSedeUsuario(): "+crearUsuarioDTO.getSedeUsuario());
		System.out.println("crearUsuarioDTO.getTelefonoUsuario(): "+crearUsuarioDTO.getTelefonoUsuario());
		model.addAttribute("mensaje", "registro exitoso desde crearUsuario");
		
		return ResponseEntity.status(HttpStatus.OK).body(alert);
	}
	
	@GetMapping("usuario/{id}")
	@ResponseBody
	public ActualizarUsuarioDTO cargarInformacionUsuario(@PathVariable("id") String idUsuario) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Usuario us = usuarioService.buscarUsuarioPorId(Integer.parseInt(idUsuario));
		DetalleUsuario du = detalleUsuarioService.extraerDetallesUsuarioPorIdUsuario(Integer.parseInt(idUsuario));
		
		String fechaFormateada = (du.getFechaNacimiento()!=null)?simpleDateFormat.format(du.getFechaNacimiento()):"";
		
		actualizarUsuarioDTO = new ActualizarUsuarioDTO();
		actualizarUsuarioDTO.setIdUsuario(idUsuario);
		actualizarUsuarioDTO.setNombreUsuario(du.getNombre());
		actualizarUsuarioDTO.setEmailUsuario(us.getEmail());
		actualizarUsuarioDTO.setPasswordUsuario(us.getPassword());
		actualizarUsuarioDTO.setRolUsuario(us.getRol());
		actualizarUsuarioDTO.setEstadoUsuario(us.getEstado());
		actualizarUsuarioDTO.setSedeUsuario(us.getSede());
		actualizarUsuarioDTO.setDireccionUsuario(du.getDireccion());
		actualizarUsuarioDTO.setDocumentoUsuario(String.valueOf(du.getDocumento()));
		actualizarUsuarioDTO.setFechaNacimiento(fechaFormateada);
		actualizarUsuarioDTO.setTelefonoUsuario(String.valueOf(du.getTelefono()));
		return actualizarUsuarioDTO;
	}
	
	@PostMapping("usuario/modificarUsuario")
	public ModelAndView actualizarUsuario(@ModelAttribute("actualizarUsuarioDTO")ActualizarUsuarioDTO actualizarUsuarioDTO) {
		ModelAndView mv = new ModelAndView();
		Usuario usuario = usuarioService.buscarUsuarioPorId(Integer.parseInt(actualizarUsuarioDTO.getIdUsuario()));
		DetalleUsuario du = detalleUsuarioService.extraerDetallesUsuarioPorIdUsuario(Integer.parseInt(actualizarUsuarioDTO.getIdUsuario()));
		Date fechaModificacion = new Date();
		
		usuario.setEmail(actualizarUsuarioDTO.getEmailUsuario());
		usuario.setEstado(actualizarUsuarioDTO.getEstadoUsuario());
		usuario.setFechaModificacion(fechaModificacion);
		usuario.setPassword(actualizarUsuarioDTO.getPasswordUsuario());
		usuario.setRol(actualizarUsuarioDTO.getRolUsuario());
		usuario.setSede(actualizarUsuarioDTO.getSedeUsuario());
		
		du.setDocumento(Long.valueOf(actualizarUsuarioDTO.getDocumentoUsuario()));
		du.setNombre(actualizarUsuarioDTO.getNombreUsuario());
		du.setFechaNacimiento(FechaConverter.convertirStringAFecha(actualizarUsuarioDTO.getFechaNacimiento()));
		du.setFechaModificacion(fechaModificacion);
		du.setDireccion(actualizarUsuarioDTO.getDireccionUsuario());
		du.setTelefono(Long.valueOf(actualizarUsuarioDTO.getTelefonoUsuario()));
		
		try {
			usuarioService.modificarUsuario(usuario);
			detalleUsuarioService.modificarDetalleUsuario(du);
		}catch(Exception e) {
			System.out.println("Error al intentar modificar el usuario - "+e.getMessage());
		}
		
		mv.setViewName("redirect:/administracion");
		return mv;
	}
	
	@GetMapping("usuario/eliminar/{id}")
	public ModelAndView eliminarUsuario(@PathVariable("id") String idUsuario) {
		ModelAndView mv = new ModelAndView();
		System.out.println("ID ELIMINADO: "+idUsuario);
		mv.setViewName("redirect:/administracion");
		return mv;
	}


//	@GetMapping(value = "/logo", produces = MediaType.IMAGE_PNG_VALUE)
//	public void getLogoImagen(HttpServletResponse response) throws IOException {
//		Path path = Paths.get("src/main/resources/static/images/logo_reportes.png");
//		byte[] imageByte = Files.readAllBytes(path);
//        try {
//            response.setContentType(MediaType.IMAGE_PNG_VALUE);
//            response.getOutputStream().write(imageByte);
//        }catch (Exception e) {
//            e.printStackTrace();
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            response.getWriter().write("Error generating report: " + e.getMessage());
//        }
//	}
}

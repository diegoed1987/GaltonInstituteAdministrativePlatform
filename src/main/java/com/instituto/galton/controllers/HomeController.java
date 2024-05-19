package com.instituto.galton.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.instituto.galton.models.Usuario;
import com.instituto.galton.services.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public ModelAndView paginaAdministrador(@ModelAttribute(name = "emailUsuario", binding = false) String emailUsuario) {
		ModelAndView model = new ModelAndView();
		//Usuario usuario = usuarioService.buscarUsuarioPorCorreo(emailUsuario);
		//model.addObject("rol", usuario.getRol());
		model.setViewName("inicio");
		return model;
	}
}

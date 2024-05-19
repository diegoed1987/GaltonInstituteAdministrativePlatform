package com.instituto.galton.controllers.administracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.instituto.galton.dtos.ActualizarBancoDTO;
import com.instituto.galton.dtos.CrearBancoDTO;
import com.instituto.galton.models.Banco;
import com.instituto.galton.services.BancoService;

@Controller
public class BancoController {
	
	@Autowired
	private BancoService bancoService;
	
	@GetMapping("banco/crearBanco")
	public ModelAndView crearBanco(@ModelAttribute("crearBancoDTO") CrearBancoDTO crearBancoDTO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/administracion");
		return mv;
	}
	
	@GetMapping("banco/cargarInformacionBanco/{idBanco}")
	@ResponseBody
	public ActualizarBancoDTO cargarInformacionBanco(@PathVariable("idBanco") String idBanco) {
		
		Banco banco = bancoService.extraerBancoIdBanco(Integer.parseInt(idBanco));
		ActualizarBancoDTO dto = new ActualizarBancoDTO();
		
		dto.setIdBanco(String.valueOf(banco.getId()));
		dto.setNombreBanco(banco.getNombreBanco());
		dto.setEstadoBanco(banco.getEstadoBanco());
		
		return dto;
	}
}

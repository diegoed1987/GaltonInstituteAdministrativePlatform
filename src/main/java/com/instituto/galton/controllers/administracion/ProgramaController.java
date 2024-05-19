package com.instituto.galton.controllers.administracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.instituto.galton.dtos.ActualizarProgramaDTO;
import com.instituto.galton.dtos.CrearProgramaDTO;
import com.instituto.galton.models.Programa;
import com.instituto.galton.services.ProgramaService;

@Controller
public class ProgramaController {
	
	@Autowired
	private ProgramaService programaService;
	
	@GetMapping("programa/crearPrograma")
	public ModelAndView crearPrograma(@ModelAttribute("crearProgramaDTO") CrearProgramaDTO crearProgramaDTO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/administracion");
		return mv;
	}
	
	@GetMapping("programa/cargarInformacionPrograma/{idPrograma}")
	@ResponseBody
	public ActualizarProgramaDTO cargarInformacionPrograma(@PathVariable("idPrograma") String idPrograma) {
	
		Programa programa = programaService.extraerProgramaIdPrograma(Integer.parseInt(idPrograma));
		ActualizarProgramaDTO dto = new ActualizarProgramaDTO();
	
		dto.setIdPrograma(String.valueOf(programa.getIdPrograma()));
		dto.setNombrePrograma(programa.getNombrePrograma());
		dto.setNombreCortoPrograma(programa.getNombreCortoPrograma());
		dto.setEstadoPrograma(programa.getEstadoPrograma());
		
		return dto;
	}
}

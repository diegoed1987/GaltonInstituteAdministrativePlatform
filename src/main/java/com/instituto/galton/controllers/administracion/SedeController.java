package com.instituto.galton.controllers.administracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.instituto.galton.dtos.ActualizarSedeDTO;
import com.instituto.galton.models.Departamento;
import com.instituto.galton.models.Municipio;
import com.instituto.galton.models.Sede;
import com.instituto.galton.services.DepartamentoService;
import com.instituto.galton.services.MunicipioService;
import com.instituto.galton.services.SedeService;

@Controller
public class SedeController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private SedeService sedeService;
	
	@GetMapping("sede/listaDepartamentos")
	@ResponseBody
	public Iterable<Departamento> getListaDepartametos(Model model){
		Iterable<Departamento> listaDepartamentos = departamentoService.getDepartamentos();
		return listaDepartamentos;
	};
	
	@GetMapping("sede/listaMunicipios/{idDepartamento}")
	@ResponseBody
	public Iterable<Municipio> getListaMunicipiosPorDepartamento(@PathVariable("idDepartamento") String idDepartamento){
		Iterable<Municipio> listaMunicipios = municipioService.getMunicipiosPorDepartamento(Integer.parseInt(idDepartamento));
		return listaMunicipios;
	};
	
	@GetMapping("sede/cargarInformacionSede/{idSede}")
	@ResponseBody
	public ActualizarSedeDTO getInformacionSede(@PathVariable("idSede")String idSede) {
		System.out.println("Sede seleccionada: "+idSede);
		ActualizarSedeDTO actualizarSedeDTO = new ActualizarSedeDTO();
		
		Sede sede = sedeService.getSede(idSede);
		actualizarSedeDTO.setCodigoSede(sede.getCodigoSede());
		actualizarSedeDTO.setNombreSede(sede.getNombreSede());
		actualizarSedeDTO.setDireccionSede(sede.getDireccionSede());
		actualizarSedeDTO.setDepartamentoSede(String.valueOf(sede.getDepartamentoSede()));
		actualizarSedeDTO.setMunicipioSede(String.valueOf(sede.getMunicipioSede()));
		actualizarSedeDTO.setTelefonoSede(sede.getTelefonoSede());
		return actualizarSedeDTO;
	}
	
	@PostMapping("sede/modificarSede")
	public ModelAndView modificarSede(@ModelAttribute("actualizarSede")Sede sede) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Sede ID: "+sede.getCodigoSede()+", actualizado.");
		mv.setViewName("redirect:/administracion");
		return mv;
	}
	
	@GetMapping("sede/eliminarSede/{idSede}")
	public ModelAndView seliminarSede(@PathVariable("idSede")String idSede) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Sede ID: "+idSede+", eliminado.");
		mv.setViewName("redirect:/administracion");
		return mv;
	}
	
}

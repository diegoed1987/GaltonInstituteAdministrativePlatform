package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Periodo;
import com.instituto.galton.repositories.PeriodoRepository;

@Service
public class PeriodoServiceImpl implements PeriodoService {

	@Autowired
	private PeriodoRepository periodoRepository;
	
	@Override
	public void crearPeriodo(Periodo periodo) {
		periodoRepository.save(periodo);
	}

	@Override
	public boolean validarPeriodo(int id) {
		return periodoRepository.existsById(id);
	}

	@Override
	public Periodo extraerPeriodoIdPeriodo(int id) {
		return periodoRepository.findById(id);
	}

	@Override
	public Iterable<Periodo> getPeriodos() {
		return periodoRepository.findAll();
	}

	@Override
	public String getNombrePeriodo(Iterable<Periodo> periodos, int periodoSeleccionado) {
		
		String nombrePeriodo = "";
		
		for(Periodo item: periodos) {
			if(item.getId() == periodoSeleccionado) {
				nombrePeriodo = item.getNombreCortoPeriodo();
				break;
			}
		}
		
		return nombrePeriodo;
	}
	
	

}

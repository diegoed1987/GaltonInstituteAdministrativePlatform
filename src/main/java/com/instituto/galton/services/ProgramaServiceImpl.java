package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Programa;

import com.instituto.galton.repositories.ProgramaRepository;

@Service
public class ProgramaServiceImpl implements ProgramaService{

	@Autowired
	private ProgramaRepository programaRepository;
	
	
	@Override
	public void crearPrograma(Programa programa) {
		programaRepository.save(programa);
		
	}

	@Override
	public boolean validarPrograma(int idPrograma) {
		return programaRepository.existsByIdPrograma(idPrograma);
	}

	@Override
	public Programa extraerProgramaIdPrograma(int idPrograma) {
		return programaRepository.findByIdPrograma(idPrograma);
	}

	@Override
	public Iterable<Programa> getProgramas() {
		return programaRepository.findAll();
	}

	@Override
	public String getNombrePrograma(Iterable<Programa> programas, int programaSeleccionado) {
		
		String nombrePrograma = "";
		
		for(Programa item : programas) {
			if(item.getIdPrograma() == programaSeleccionado) {
				nombrePrograma = item.getNombrePrograma();
				break;
			}
		}
		
		return nombrePrograma;
	}

}

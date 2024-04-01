package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Egresos;
import com.instituto.galton.repositories.EgresoRepository;

@Service
public class EgresoServiceImpl implements EgresoService {

	@Autowired
	private EgresoRepository egresoRepository;
	
	@Override
	@Async
	public void crearEgreso(Egresos egresos) {
		egresoRepository.save(egresos);
		
	}

	@Override
	public boolean validarEgresos(int idEgreso) {
		return egresoRepository.existsByIdEgreso(idEgreso);
	}

	@Override
	public Egresos extraerEgresoPorIdEgreso(int idEgreso) {
		return egresoRepository.findByIdEgreso(idEgreso);
	}

	@Override
	public String getMaxEgresoId() {
		return String.valueOf(egresoRepository.getMaxId());
	}

}

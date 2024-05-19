package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Municipio;
import com.instituto.galton.repositories.MunicipioRepository;

@Service
public class MunicipioServiceImp implements MunicipioService{

	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Override
	public Iterable<Municipio> getMunicipiosPorDepartamento(int idDepartamento) {
		return municipioRepository.findByCodigoDepartamento(idDepartamento);
	}
	
}

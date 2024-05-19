package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Departamento;
import com.instituto.galton.repositories.DepartamentoRepository;

@Service
public class DepartamentoServiceImp implements DepartamentoService{

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Override
	public Iterable<Departamento> getDepartamentos() {
		return departamentoRepository.findAll();
	}

}

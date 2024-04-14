package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Sede;
import com.instituto.galton.repositories.SedeRepository;

@Service
public class SedeServiceImp implements SedeService{

	@Autowired
	SedeRepository sedeRepository;
	
	@Override
	public Iterable<Sede> getSedes() {
		return sedeRepository.findAll();
	}

}

package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.DetalleDominio;
import com.instituto.galton.repositories.DetalleDominioRepository;

@Service
public class DetalleDominioServiceImp implements DetalleDominioService{

	@Autowired
	private DetalleDominioRepository detalleDominioRepository;
	
	@Override
	public DetalleDominio consultaDominio(String idDominio, String nombreDetalle) {
		return detalleDominioRepository.findByIdDominioAndNombreDetalle(idDominio, nombreDetalle);
	}

}

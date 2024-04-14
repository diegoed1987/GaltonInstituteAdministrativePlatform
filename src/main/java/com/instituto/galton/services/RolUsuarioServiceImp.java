package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.RolUsuario;
import com.instituto.galton.repositories.RolUsuarioRepository;

@Service
public class RolUsuarioServiceImp implements RolUsuarioService{

	@Autowired
	RolUsuarioRepository rolUsuarioRepository;
	
	@Override
	public Iterable<RolUsuario> getRolesUsuarios() {
		return rolUsuarioRepository.findAll();
	}
}

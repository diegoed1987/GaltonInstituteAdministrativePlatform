package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.RolUsuario;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer>{
	
	public List<RolUsuario> findAll();
}

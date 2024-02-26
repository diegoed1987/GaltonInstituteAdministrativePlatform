package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.DetalleUsuario;

public interface DetalleUsuarioRepository extends JpaRepository<DetalleUsuario, Integer>{
	public List<DetalleUsuario> findAll();
	public boolean existsByDocumento(int documento);
	
}

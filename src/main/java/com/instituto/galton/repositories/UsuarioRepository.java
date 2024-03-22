package com.instituto.galton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instituto.galton.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	public List<Usuario> findAll();
	public boolean existsByEmail(String email);
	public boolean existsByEmailAndPassword(String email, String password);
	public Usuario findByEmail(String email);
}

package com.instituto.galton.services;

import java.util.List;

import com.instituto.galton.models.Usuario;

public interface UsuarioService {
	
	public Usuario crearUsuario(Usuario usuario);
	public List<Usuario> consultarUsuarios();
}

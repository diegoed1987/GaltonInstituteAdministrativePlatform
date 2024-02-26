package com.instituto.galton.services;

import java.util.List;

import com.instituto.galton.models.Usuario;

public interface UsuarioService {
	
	public Usuario crearUsuario(Usuario usuario);
	public List<Usuario> consultarUsuarios();
	public boolean validarCorreo(String email);
	public boolean validarInicioSession(String email, String password);
}
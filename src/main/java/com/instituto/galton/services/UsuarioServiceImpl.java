package com.instituto.galton.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Usuario;
import com.instituto.galton.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public List<Usuario> consultarUsuarios(){
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		return listaUsuarios;
	}
}

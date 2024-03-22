package com.instituto.galton.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.Usuario;
import com.instituto.galton.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		
		if(usuario != null) {
			return new CustomUserDetails(usuario);
		}
		throw new UsernameNotFoundException("Usuario no disponible");
	}

}

package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.galton.models.DetalleUsuario;
import com.instituto.galton.repositories.DetalleUsuarioRepository;

@Service
public class DetalleUsuarioServiceImpl implements DetalleUsuarioService{
	
	@Autowired
	private DetalleUsuarioRepository detalleUsuarioRepository;

	@Override
	public void crearDetalleUsuario(DetalleUsuario detalleUsuario) {
		detalleUsuarioRepository.save(detalleUsuario);
		
	}

	@Override
	public boolean validarDocumento(int documento) {
		return detalleUsuarioRepository.existsByDocumento(documento);
	}

	@Override
	public DetalleUsuario extraerDetallesUsuarioPorIdUsuario(int idUsuario) {
		return detalleUsuarioRepository.findByIdUsuario(idUsuario);
	}

}

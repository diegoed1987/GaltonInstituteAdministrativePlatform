package com.instituto.galton.services;

import com.instituto.galton.models.DetalleUsuario;

public interface DetalleUsuarioService {
	public void crearDetalleUsuario(DetalleUsuario detalleUsuario);
	public boolean validarDocumento(int documento);
	public DetalleUsuario extraerDetallesUsuarioPorIdUsuario(int idUsuario);
	public void modificarDetalleUsuario(DetalleUsuario detalleUsuario);
}

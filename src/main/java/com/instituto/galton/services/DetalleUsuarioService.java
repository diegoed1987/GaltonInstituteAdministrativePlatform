package com.instituto.galton.services;

import com.instituto.galton.models.DetalleUsuario;

public interface DetalleUsuarioService {
	public void crearDetalleUsuario(DetalleUsuario detalleUsuario);
	public boolean validarDocumento(int documento);
}

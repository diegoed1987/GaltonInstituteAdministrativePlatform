package com.instituto.galton.services;

import com.instituto.galton.models.Banco;


public interface BancoService {

	public void crearBanco(Banco banco);
	public boolean validarBanco(int id);
	public Banco extraerBancoIdBanco(int id);
	
}

package com.instituto.galton.services;

import com.instituto.galton.models.Periodo;

public interface PeriodoService {

	public void crearPeriodo(Periodo periodo);
	public boolean validarPeriodo(int id);
	public Periodo extraerPeriodoIdPeriodo(int id);
	
}

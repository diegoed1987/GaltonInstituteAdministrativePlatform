package com.instituto.galton.services;

import com.instituto.galton.models.Egresos;


public interface EgresoService {

	public void crearEgreso(Egresos egresos);
	public boolean validarEgresos(int idEgreso);
	public Egresos extraerEgresoPorIdEgreso(int idEgreso);
	public String getMaxEgresoId();
	
}

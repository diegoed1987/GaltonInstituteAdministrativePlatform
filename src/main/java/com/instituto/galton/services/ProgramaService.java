package com.instituto.galton.services;

import com.instituto.galton.models.Programa;

public interface ProgramaService {
	
	public void crearPrograma(Programa programa);
	public boolean validarPrograma(int idPrograma);
	public Programa extraerProgramaIdPrograma(int idPrograma);

}

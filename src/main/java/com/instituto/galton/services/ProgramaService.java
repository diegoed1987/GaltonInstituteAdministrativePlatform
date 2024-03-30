package com.instituto.galton.services;

import com.instituto.galton.models.Programa;

public interface ProgramaService {
	
	public void crearPrograma(Programa programa);
	public boolean validarPrograma(int idPrograma);
	public Programa extraerProgramaIdPrograma(int idPrograma);
	public Iterable<Programa> getProgramas();
	public String getNombrePrograma(Iterable<Programa> programas, int programaSeleccionado);

}

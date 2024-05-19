package com.instituto.galton.dtos;

public class CrearProgramaDTO {
	
	private String nombrePrograma;
	private String nombreCortoPrograma;
	private String estadoPrograma;
	
	public CrearProgramaDTO() {
		super();
	}

	public CrearProgramaDTO(String nombrePrograma, String nombreCortoPrograma, String estadoPrograma) {
		super();
		this.nombrePrograma = nombrePrograma;
		this.nombreCortoPrograma = nombreCortoPrograma;
		this.estadoPrograma = estadoPrograma;
	}
	
	public String getNombrePrograma() {
		return nombrePrograma;
	}
	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}
	public String getNombreCortoPrograma() {
		return nombreCortoPrograma;
	}
	public void setNombreCortoPrograma(String nombreCortoPrograma) {
		this.nombreCortoPrograma = nombreCortoPrograma;
	}
	public String getEstadoPrograma() {
		return estadoPrograma;
	}
	public void setEstadoPrograma(String estadoPrograma) {
		this.estadoPrograma = estadoPrograma;
	}
	
	
}

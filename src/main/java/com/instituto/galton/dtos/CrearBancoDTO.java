package com.instituto.galton.dtos;

public class CrearBancoDTO {

	private String nombreBanco;
	private String estadoBanco;
	
	public CrearBancoDTO() {
		super();
	}
	public CrearBancoDTO(String nombreBanco, String estadoBanco) {
		super();
		this.nombreBanco = nombreBanco;
		this.estadoBanco = estadoBanco;
	}
	public String getNombreBanco() {
		return nombreBanco;
	}
	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}
	public String getEstadoBanco() {
		return estadoBanco;
	}
	public void setEstadoBanco(String estadoBanco) {
		this.estadoBanco = estadoBanco;
	}
	
	
}

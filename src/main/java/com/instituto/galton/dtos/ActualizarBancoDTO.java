package com.instituto.galton.dtos;

public class ActualizarBancoDTO {

	private String idBanco;
	private String nombreBanco;
	private String estadoBanco;
	
	public ActualizarBancoDTO() {
		super();
	}

	public ActualizarBancoDTO(String idBanco, String nombreBanco, String estadoBanco) {
		super();
		this.idBanco = idBanco;
		this.nombreBanco = nombreBanco;
		this.estadoBanco = estadoBanco;
	}
	
	public String getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
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

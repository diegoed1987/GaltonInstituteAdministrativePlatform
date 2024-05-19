package com.instituto.galton.dtos;

public class CrearSedeDTO {
	
	private String nombreSede;
	private String ubicacionSede;
	private String direccionSede;
	private String departamentoSede;
	private String municipioSede;
	private String telefonoSede;
	
	public CrearSedeDTO() {
		super();
	}

	public CrearSedeDTO(String nombreSede, String ubicacionSede, String direccionSede, String departamentoSede,
			String municipioSede, String telefonoSede) {
		super();
		this.nombreSede = nombreSede;
		this.ubicacionSede = ubicacionSede;
		this.direccionSede = direccionSede;
		this.departamentoSede = departamentoSede;
		this.municipioSede = municipioSede;
		this.telefonoSede = telefonoSede;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public String getUbicacionSede() {
		return ubicacionSede;
	}

	public void setUbicacionSede(String ubicacionSede) {
		this.ubicacionSede = ubicacionSede;
	}

	public String getDireccionSede() {
		return direccionSede;
	}

	public void setDireccionSede(String direccionSede) {
		this.direccionSede = direccionSede;
	}

	public String getDepartamentoSede() {
		return departamentoSede;
	}

	public void setDepartamentoSede(String departamentoSede) {
		this.departamentoSede = departamentoSede;
	}

	public String getMunicipioSede() {
		return municipioSede;
	}

	public void setMunicipioSede(String municipioSede) {
		this.municipioSede = municipioSede;
	}

	public String getTelefonoSede() {
		return telefonoSede;
	}

	public void setTelefonoSede(String telefonoSede) {
		this.telefonoSede = telefonoSede;
	}

}

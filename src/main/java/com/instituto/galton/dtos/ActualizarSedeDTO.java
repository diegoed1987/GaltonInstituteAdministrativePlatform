package com.instituto.galton.dtos;

import java.util.Date;

public class ActualizarSedeDTO {

	private String codigoSede;
	private String nombreSede;
	private String direccionSede;
	private String departamentoSede;
	private String municipioSede;
	private String telefonoSede;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	public ActualizarSedeDTO() {
		super();
	}

	public ActualizarSedeDTO(String codigoSede, String nombreSede, String direccionSede, String departamentoSede,
			String municipioSede, String telefonoSede, Date fechaCreacion, Date fechaModificacion) {
		super();
		this.codigoSede = codigoSede;
		this.nombreSede = nombreSede;
		this.direccionSede = direccionSede;
		this.departamentoSede = departamentoSede;
		this.municipioSede = municipioSede;
		this.telefonoSede = telefonoSede;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}
	
	public String getCodigoSede() {
		return codigoSede;
	}
	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
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
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	
	
}

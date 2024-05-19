package com.instituto.galton.dtos;

import java.sql.Date;

public class ActualizarProgramaDTO {
	
	private String idPrograma;
	private String nombrePrograma;
	private String nombreCortoPrograma;
	private String estadoPrograma;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	public ActualizarProgramaDTO() {
		super();
	}
	
	public ActualizarProgramaDTO(String idPrograma, String nombrePrograma, String nombreCortoPrograma,
			String estadoPrograma, Date fechaCreacion, Date fechaModificacion) {
		super();
		this.idPrograma = idPrograma;
		this.nombrePrograma = nombrePrograma;
		this.nombreCortoPrograma = nombreCortoPrograma;
		this.estadoPrograma = estadoPrograma;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}
	public String getIdPrograma() {
		return idPrograma;
	}
	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
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

package com.instituto.galton.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROGRAMAS")
public class Programa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "ID_PROGRAMA")
	private int idPrograma;
	
	@Column (name= "NOMBRE_PROGRAMA")
	private String nombrePrograma;
	
	@Column (name= "NOMBRE_CORTO")
	private String nombreCortoPrograma;
	
	@Column (name= "ESTADO")
	private String estadoPrograma;
	
	@Column (name= "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column (name= "FECHA_MODIFICACION")
	private Date fechaModificacion;

	public int getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
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

	@Override
	public String toString() {
		return "Programa [idPrograma=" + idPrograma + ", nombrePrograma=" + nombrePrograma + ", nombreCortoPrograma="
				+ nombreCortoPrograma + ", estadoPrograma=" + estadoPrograma + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + "]";
	}
	
	

}

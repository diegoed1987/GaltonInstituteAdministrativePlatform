package com.instituto.galton.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento {

	@Id
	@Column(name = "CODIGO_DEPARTAMENTO")
	private int codigoDepartamento;
	
	@Column(name = "NOMBRE_DEPARTAMENTO")
	private String nombreDepartamento;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;

	public Departamento() {
		super();
	}

	public Departamento(int codigoDepartamento, String nombreDepartamento, Date fechaCreacion,
			Date fechaModificacion) {
		super();
		this.codigoDepartamento = codigoDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public int getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(int codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
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
		return "Departamento [codigoDepartamento=" + codigoDepartamento + ", nombreDepartamento=" + nombreDepartamento
				+ ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + "]";
	}

}

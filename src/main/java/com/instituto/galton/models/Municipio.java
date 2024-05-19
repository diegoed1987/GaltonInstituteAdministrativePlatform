package com.instituto.galton.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MUNICIPIOS")
public class Municipio {
	
	@Id
	@Column(name = "CODIGO_MUNICIPIO")
	private int codigoMunicipio;
	
	@Column(name = "NOMBRE_MUNICIPIO")
	private String nombreMunicipio;
	
	@Column(name = "CODIGO_DEPARTAMENTO")
	private int codigoDepartamento;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;

	public Municipio() {
		super();
	}

	public Municipio(int codigoMunicipio, String nombreMunicipio, int codigoDepartamento, Date fechaCreacion,
			Date fechaModificacion) {
		super();
		this.codigoMunicipio = codigoMunicipio;
		this.nombreMunicipio = nombreMunicipio;
		this.codigoDepartamento = codigoDepartamento;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public int getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(int codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public int getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(int codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
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
		return "Municipio [codigoMunicipio=" + codigoMunicipio + ", nombreMunicipio=" + nombreMunicipio
				+ ", codigoDepartamento=" + codigoDepartamento + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + "]";
	}

}

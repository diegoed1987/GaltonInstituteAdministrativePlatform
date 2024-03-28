package com.instituto.galton.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANCOS")
public class Banco {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "ID_BANCO")
	private int id;
	
	@Column (name= "NOMBRE_BANCO")
	private String nombreBanco;
	
	@Column (name= "ESTADO")
	private String estadoBanco;
	
	@Column (name= "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column (name= "FECHA_MODIFICACION")
	private Date fechaModificacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Banco [id=" + id + ", nombreBanco=" + nombreBanco + ", estadoBanco=" + estadoBanco + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion + "]";
	}
}

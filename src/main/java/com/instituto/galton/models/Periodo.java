package com.instituto.galton.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERIODOS")
public class Periodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "ID_PERIODO")
	private int id;
	
	@Column (name= "PERIODO")
	private String periodo;
	
	@Column (name= "NOMBRE_CORTO")
	private String nombreCortoPeriodo;
	
	@Column (name= "ESTADO")
	private String estadoPeriodo;
	
	@Column (name= "FECHA_CREACION")
	private Date fechaCreacionPeriodo;
	
	@Column (name= "FECHA_MODIFICACION")
	private Date fechaModificacionPeriodo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNombreCortoPeriodo() {
		return nombreCortoPeriodo;
	}

	public void setNombreCortoPeriodo(String nombreCortoPeriodo) {
		this.nombreCortoPeriodo = nombreCortoPeriodo;
	}

	public String getEstadoPeriodo() {
		return estadoPeriodo;
	}

	public void setEstadoPeriodo(String estadoPeriodo) {
		this.estadoPeriodo = estadoPeriodo;
	}

	public Date getFechaCreacionPeriodo() {
		return fechaCreacionPeriodo;
	}

	public void setFechaCreacionPeriodo(Date fechaCreacionPeriodo) {
		this.fechaCreacionPeriodo = fechaCreacionPeriodo;
	}

	public Date getFechaModificacionPeriodo() {
		return fechaModificacionPeriodo;
	}

	public void setFechaModificacionPeriodo(Date fechaModificacionPeriodo) {
		this.fechaModificacionPeriodo = fechaModificacionPeriodo;
	}

	@Override
	public String toString() {
		return "Periodo [id=" + id + ", periodo=" + periodo + ", nombreCortoPeriodo=" + nombreCortoPeriodo
				+ ", estadoPeriodo=" + estadoPeriodo + ", fechaCreacionPeriodo=" + fechaCreacionPeriodo
				+ ", fechaModificacionPeriodo=" + fechaModificacionPeriodo + "]";
	}
}

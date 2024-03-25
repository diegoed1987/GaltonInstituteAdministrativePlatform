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

}

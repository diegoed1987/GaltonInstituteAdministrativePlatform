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
	private int id;
	
	@Column (name= "NOMBRE_BANCO")
	private String nombreBanco;
	
	@Column (name= "ESTADO")
	private String estadoBanco;
	
	@Column (name= "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column (name= "FECHA_MODIFICACION")
	private Date fechaModificacion;
	
}

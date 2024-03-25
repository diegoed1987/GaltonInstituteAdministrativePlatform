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

}

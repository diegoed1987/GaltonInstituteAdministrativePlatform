package com.instituto.galton.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROLES_USUARIO")
public class RolUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "ID_ROL")
	private int idRol;
	
	@Column(name = "NOMBRE_ROL")
	private String nombreRol;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;
	
	public RolUsuario() {
		super();
	}
	
	public RolUsuario(int id, int idRol, String nombreRol, Date fechaCreacion, Date fechaModificacion) {
		super();
		this.id = id;
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
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
		return "RolUsuario [id=" + id + ", idRol=" + idRol + ", nombreRol=" + nombreRol + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion + "]";
	}
}

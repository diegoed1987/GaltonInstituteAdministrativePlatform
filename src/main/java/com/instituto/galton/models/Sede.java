package com.instituto.galton.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SEDES")
public class Sede {
	
	@Id
	@Column(name = "CODIGO_SEDE")
	private String codigoSede;
	
	@Column(name = "NOMBRE_SEDE")
	private String nombreSede;
	
	@Column(name = "UBICACION_SEDE")
	private String ubicacionSede;
	
	@Column(name = "DIRECCION_SEDE")
	private String direccionSede;
	
	@Column(name = "TELEFONO_SEDE")
	private String telefonoSede;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;

	public Sede() {
		super();
	}
	
	public Sede(String codigoSede, String nombreSede, String ubicacionSede, String direccionSede, String telefonoSede,
			Date fechaCreacion, Date fechaModificacion) {
		super();
		this.codigoSede = codigoSede;
		this.nombreSede = nombreSede;
		this.ubicacionSede = ubicacionSede;
		this.direccionSede = direccionSede;
		this.telefonoSede = telefonoSede;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}
	
	public String getCodigoSede() {
		return codigoSede;
	}
	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}
	public String getUbicacionSede() {
		return ubicacionSede;
	}
	public void setUbicacionSede(String ubicacionSede) {
		this.ubicacionSede = ubicacionSede;
	}
	public String getDireccionSede() {
		return direccionSede;
	}
	public void setDireccionSede(String direccionSede) {
		this.direccionSede = direccionSede;
	}
	public String getTelefonoSede() {
		return telefonoSede;
	}
	public void setTelefonoSede(String telefonoSede) {
		this.telefonoSede = telefonoSede;
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
		return "Sede [codigoSede=" + codigoSede + ", nombreSede=" + nombreSede + ", ubicacionSede=" + ubicacionSede
				+ ", direccionSede=" + direccionSede + ", telefonoSede=" + telefonoSede + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion + "]";
	}
	
	
}

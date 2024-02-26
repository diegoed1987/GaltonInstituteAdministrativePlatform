package com.instituto.galton.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DETALLES_DOMINIO")
public class DetalleDominio {

	@Id
	@Column(name = "ID_DOMINIO")
	private String idDominio;
	
	@Column(name = "NOMBRE_DETALLE")
	private String nombreDetalle;
	
	@Column(name = "VALOR_DETALLE")
	private String valorDetalle;
	
	@Column(name = "DESCRIPCION_DETALLE")
	private String descripcionDetalle;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;

	public String getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(String idDominio) {
		this.idDominio = idDominio;
	}

	public String getNombreDetalle() {
		return nombreDetalle;
	}

	public void setNombreDetalle(String nombreDetalle) {
		this.nombreDetalle = nombreDetalle;
	}

	public String getValorDetalle() {
		return valorDetalle;
	}

	public void setValorDetalle(String valorDetalle) {
		this.valorDetalle = valorDetalle;
	}

	public String getDescripcionDetalle() {
		return descripcionDetalle;
	}

	public void setDescripcionDetalle(String descripcionDetalle) {
		this.descripcionDetalle = descripcionDetalle;
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
		return "DetalleDominio [idDominio=" + idDominio + ", nombreDetalle=" + nombreDetalle + ", valorDetalle="
				+ valorDetalle + ", descripcionDetalle=" + descripcionDetalle + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + "]";
	}
}

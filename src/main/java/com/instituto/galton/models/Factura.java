package com.instituto.galton.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FACTURAS")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfactura;
	
	@Column (name= "ID_PAGADOR")
	private int idPagador;
	
	@Column (name= "NOMBRE_PAGADOR")
	private String nombrePagador;
	
	@Column (name= "ID_PERIODO")
	private int idPeriodo;
	
	@Column (name= "ID_PROGRAMA")
	private int idPrograma;
	
	@Column (name= "FECHA_FACTURA")
	private Date fechaFactura;
	
	@Column (name= "CONCEPTO")
	private String concepto;
	
	@Column (name= "OBSERVACIONES")
	private String observaciones;
	
	@Column (name= "VALOR_RECAUDADO")
	private float valorRecaudado;
	
	@Column (name= "VALOR_LETRA")
	private String valorLetra;
	
	@Column (name= "MEDIOS_PAGO")
	private String mediosPago;
	
	@Column (name= "ID_BANCO")
	private int idBanco;

	
	
	
	public Factura() {
		super();
	}

	public int getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public int getIdPagador() {
		return idPagador;
	}

	public void setIdPagador(int idPagador) {
		this.idPagador = idPagador;
	}

	public String getNombrePagador() {
		return nombrePagador;
	}

	public void setNombrePagador(String nombrePagador) {
		this.nombrePagador = nombrePagador;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public int getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public float getValorRecaudado() {
		return valorRecaudado;
	}

	public void setValorRecaudado(float valorRecaudado) {
		this.valorRecaudado = valorRecaudado;
	}

	public String getValorLetra() {
		return valorLetra;
	}

	public void setValorLetra(String valorLetra) {
		this.valorLetra = valorLetra;
	}

	public String getMediosPago() {
		return mediosPago;
	}

	public void setMediosPago(String mediosPago) {
		this.mediosPago = mediosPago;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	@Override
	public String toString() {
		return "Factura [idfactura=" + idfactura + ", idPagador=" + idPagador + ", nombrePagador=" + nombrePagador
				+ ", idPeriodo=" + idPeriodo + ", idPrograma=" + idPrograma + ", fechaFactura=" + fechaFactura
				+ ", concepto=" + concepto + ", observaciones=" + observaciones + ", valorRecaudado=" + valorRecaudado
				+ ", valorLetra=" + valorLetra + ", mediosPago=" + mediosPago + ", idBanco=" + idBanco + "]";
	}
	
	

}

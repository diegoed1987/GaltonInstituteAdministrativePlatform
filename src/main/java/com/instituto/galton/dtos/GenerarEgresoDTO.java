package com.instituto.galton.dtos;

import java.util.Arrays;

public class GenerarEgresoDTO {
	
	private String numeroComprobante;
	private String idBeneficiario;
	private String nombreBeneficiario;
	private String direccionBeneficiario;
	private String telefonoBeneficiario;
	private String ciudadBeneficiario;
	private String medioPago;
	private String idBanco;
	private String fechaEgreso;
	private String valorEgreso;
	private String valorLetra;
	private String descripcionEgreso;
	private String observacionesEgreso;
	private String nit;
	private String direccion;
	
	public GenerarEgresoDTO() {
		super();
	}
	
	public GenerarEgresoDTO(String numeroComprobante, String idBeneficiario, String nombreBeneficiario,
			String direccionBeneficiario, String telefonoBeneficiario, String ciudadBeneficiario, String medioPago,
			String idBanco, String fechaEgreso, String valorEgreso, String valorLetra, String descripcionEgreso,
			String observacionesEgreso, String nit, String direccion, byte[] logoImagen) {
		super();
		this.numeroComprobante = numeroComprobante;
		this.idBeneficiario = idBeneficiario;
		this.nombreBeneficiario = nombreBeneficiario;
		this.direccionBeneficiario = direccionBeneficiario;
		this.telefonoBeneficiario = telefonoBeneficiario;
		this.ciudadBeneficiario = ciudadBeneficiario;
		this.medioPago = medioPago;
		this.idBanco = idBanco;
		this.fechaEgreso = fechaEgreso;
		this.valorEgreso = valorEgreso;
		this.valorLetra = valorLetra;
		this.descripcionEgreso = descripcionEgreso;
		this.observacionesEgreso = observacionesEgreso;
		this.nit = nit;
		this.direccion = direccion;
	}
	public String getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public String getIdBeneficiario() {
		return idBeneficiario;
	}
	public void setIdBeneficiario(String idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}
	public String getDireccionBeneficiario() {
		return direccionBeneficiario;
	}
	public void setDireccionBeneficiario(String direccionBeneficiario) {
		this.direccionBeneficiario = direccionBeneficiario;
	}
	public String getTelefonoBeneficiario() {
		return telefonoBeneficiario;
	}
	public void setTelefonoBeneficiario(String telefonoBeneficiario) {
		this.telefonoBeneficiario = telefonoBeneficiario;
	}
	public String getCiudadBeneficiario() {
		return ciudadBeneficiario;
	}
	public void setCiudadBeneficiario(String ciudadBeneficiario) {
		this.ciudadBeneficiario = ciudadBeneficiario;
	}
	public String getMedioPago() {
		return medioPago;
	}
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}
	public String getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}
	public String getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(String fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	public String getValorEgreso() {
		return valorEgreso;
	}
	public void setValorEgreso(String valorEgreso) {
		this.valorEgreso = valorEgreso;
	}
	public String getValorLetra() {
		return valorLetra;
	}
	public void setValorLetra(String valorLetra) {
		this.valorLetra = valorLetra;
	}
	public String getDescripcionEgreso() {
		return descripcionEgreso;
	}
	public void setDescripcionEgreso(String descripcionEgreso) {
		this.descripcionEgreso = descripcionEgreso;
	}
	public String getObservacionesEgreso() {
		return observacionesEgreso;
	}
	public void setObservacionesEgreso(String observacionesEgreso) {
		this.observacionesEgreso = observacionesEgreso;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "GenerarEgresoDTO [numeroComprobante=" + numeroComprobante + ", idBeneficiario=" + idBeneficiario
				+ ", nombreBeneficiario=" + nombreBeneficiario + ", direccionBeneficiario=" + direccionBeneficiario
				+ ", telefonoBeneficiario=" + telefonoBeneficiario + ", ciudadBeneficiario=" + ciudadBeneficiario
				+ ", medioPago=" + medioPago + ", idBanco=" + idBanco + ", fechaEgreso=" + fechaEgreso
				+ ", valorEgreso=" + valorEgreso + ", valorLetra=" + valorLetra + ", descripcionEgreso="
				+ descripcionEgreso + ", observacionesEgreso=" + observacionesEgreso + ", nit=" + nit + ", direccion="
				+ direccion + "]";
	}
	
	
}

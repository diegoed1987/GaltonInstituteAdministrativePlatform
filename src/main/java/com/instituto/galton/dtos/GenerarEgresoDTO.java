package com.instituto.galton.dtos;

public class GenerarEgresoDTO {
	
	private String idEgreso;
	private String idBeneficiario;
	private String nombreBeneficiario;
	private String direccionBeneficiario;
	private String telefonoBeneficiario;
	private String ciudadBeneficiario;
	private String mediosPago;
	private String idBanco;
	private String fechaEgreso;
	private String valorEgreso;
	private String valorLetra;
	private String descripcionEgreso;
	private String observacionesEgreso;
	private String numeroEgreso;
	private String nit;
	private String direccion;
	
	
	
	public GenerarEgresoDTO() {
		super();
	}
	
	
	
	public GenerarEgresoDTO(String idEgreso, String idBeneficiario, String nombreBeneficiario, String direccionBeneficiario,
			String telefonoBeneficiario, String ciudadBeneficiario, String mediosPago, String idBanco,
			String fechaEgreso, String valorEgreso, String valorLetra, String descripcionEgreso,
			String observacionesEgreso, String numeroEgreso,String nit, String direccion) {
		super();
		this.idEgreso = idEgreso;
		this.idBeneficiario = idBeneficiario;
		this.nombreBeneficiario = nombreBeneficiario;
		this.direccionBeneficiario = direccionBeneficiario;
		this.telefonoBeneficiario = telefonoBeneficiario;
		this.ciudadBeneficiario = ciudadBeneficiario;
		this.mediosPago = mediosPago;
		this.idBanco = idBanco;
		this.fechaEgreso = fechaEgreso;
		this.valorEgreso = valorEgreso;
		this.valorLetra = valorLetra;
		this.descripcionEgreso = descripcionEgreso;
		this.observacionesEgreso = observacionesEgreso;
		this.numeroEgreso = numeroEgreso;
		this.nit = nit;
		this.direccion = direccion;
	}



	public String getIdEgreso() {
		return idEgreso;
	}
	public void setIdEgreso(String idEgreso) {
		this.idEgreso = idEgreso;
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
	public String getMediosPago() {
		return mediosPago;
	}
	public void setMediosPago(String mediosPago) {
		this.mediosPago = mediosPago;
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
	
	public String getNumeroEgreso() {
		return numeroEgreso;
	}
	public void setNumeroEgreso(String numeroEgreso) {
		this.numeroEgreso = numeroEgreso;
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
		return "GenerarEgresoDTO [idEgreso=" + idEgreso + ", nombreBeneficiario=" + nombreBeneficiario
				+ ", direccionBeneficiario=" + direccionBeneficiario + ", telefonoBeneficiario=" + telefonoBeneficiario
				+ ", ciudadBeneficiario=" + ciudadBeneficiario + ", mediosPago=" + mediosPago + ", idBanco=" + idBanco
				+ ", fechaEgreso=" + fechaEgreso + ", valorEgreso=" + valorEgreso + ", valorLetra=" + valorLetra
				+ ", descripcionEgreso=" + descripcionEgreso + ", observacionesEgreso=" + observacionesEgreso + ", nit="
				+ nit + ", direccion=" + direccion + "]";
	}
	
	
	

}

package com.instituto.galton.dtos;

public class GenerarFacturaDTO {
	
	private String documentoPagador;
	private String nombrePagador;
	private String periodo;
	private String programa;
	private String concepto;
	private String valorRecaudado;
	private String valorLetra;
	private String medioPago;
	private String banco;
	private String observaciones;
	private String fechaRecibo;
	private String numeroRecibo;
	private String email;
	private String telefono;
	
	public GenerarFacturaDTO() {
		super();
	}
	
	public GenerarFacturaDTO(String documentoPagador, String nombrePagador, String periodo, String programa,
			String concepto, String valorRecaudado, String valorLetra, String medioPago, String banco,
			String observaciones, String fechaRecibo, String numeroRecibo, String email, String telefono) {
		super();
		this.documentoPagador = documentoPagador;
		this.nombrePagador = nombrePagador;
		this.periodo = periodo;
		this.programa = programa;
		this.concepto = concepto;
		this.valorRecaudado = valorRecaudado;
		this.valorLetra = valorLetra;
		this.medioPago = medioPago;
		this.banco = banco;
		this.observaciones = observaciones;
		this.fechaRecibo = fechaRecibo;
		this.numeroRecibo = numeroRecibo;
		this.email = email;
		this.telefono = telefono;
	}
	
	public String getDocumentoPagador() {
		return documentoPagador;
	}
	
	public void setDocumentoPagador(String documentoPagador) {
		this.documentoPagador = documentoPagador;
	}
	
	public String getNombrePagador() {
		return nombrePagador;
	}
	
	public void setNombrePagador(String nombrePagador) {
		this.nombrePagador = nombrePagador;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getPrograma() {
		return programa;
	}
	
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	
	public String getConcepto() {
		return concepto;
	}
	
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	public String getValorRecaudado() {
		return valorRecaudado;
	}
	
	public void setValorRecaudado(String valorRecaudado) {
		this.valorRecaudado = valorRecaudado;
	}
	
	public String getValorLetra() {
		return valorLetra;
	}
	
	public void setValorLetra(String valorLetra) {
		this.valorLetra = valorLetra;
	}
	
	public String getMedioPago() {
		return medioPago;
	}
	
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}
	
	public String getBanco() {
		return banco;
	}
	
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String getFechaRecibo() {
		return fechaRecibo;
	}
	
	public void setFechaRecibo(String fechaRecibo) {
		this.fechaRecibo = fechaRecibo;
	}
	
	public String getNumeroRecibo() {
		return numeroRecibo;
	}
	
	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "GenerarFacturaDTO [documentoPagador=" + documentoPagador + ", nombrePagador=" + nombrePagador
				+ ", periodo=" + periodo + ", programa=" + programa + ", concepto=" + concepto + ", valorRecaudado="
				+ valorRecaudado + ", valorLetra=" + valorLetra + ", medioPago=" + medioPago + ", banco=" + banco
				+ ", observaciones=" + observaciones + ", fechaRecibo=" + fechaRecibo + ", numeroRecibo=" + numeroRecibo
				+ ", email=" + email + ", telefono=" + telefono + "]";
	}
}

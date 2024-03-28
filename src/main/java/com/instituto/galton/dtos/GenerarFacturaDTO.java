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
	
	public GenerarFacturaDTO() {
	}

	public GenerarFacturaDTO(String documentoPagador, String nombrePagador, String periodo, String programa,
			String concepto, String valorRecaudado, String valorLetra, String medioPago, String banco,
			String observaciones) {
		
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
	
	@Override
	public String toString() {
		return "GenerarFacturaDTO [documentoPagador=" + documentoPagador + ", nombrePagador=" + nombrePagador
				+ ", periodo=" + periodo + ", programa=" + programa + ", concepto=" + concepto + ", valorRecaudado="
				+ valorRecaudado + ", valorLetra=" + valorLetra + ", medioPago=" + medioPago + ", banco=" + banco
				+ ", observaciones=" + observaciones + "]";
	}
}

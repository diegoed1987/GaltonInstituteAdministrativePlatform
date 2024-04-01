package com.instituto.galton.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EGRESOS")
public class Egresos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "ID_EGRESO")
	private int idEgreso;
	
	@Column (name= "ID_BENEFICIARIO")
	private int idBeneficiario;
	
	@Column (name= "NOMBRE_BENEFICIARIO")
	private String nombreBeneficiario;
	
	@Column (name= "DIRECCION_BENEFICIARIO")
	private String direccionBeneficiario;
	
	@Column (name= "TELEFONO_BENEFICIARIO")
	private String telefonoBeneficiario;
	
	@Column (name= "CIUDAD_BENEFICIARIO")
	private String ciudadBeneficiario;

	@Column (name= "MEDIOS_PAGO")
	private String mediosPago;
	
	@Column (name= "ID_BANCO")
	private int idBanco;
	
	@Column (name= "FECHA_EGRESO")
	private Date fechaEgreso;
	
	@Column (name= "VALOR_EGRESO")
	private float valorEgreso;
	
	@Column (name= "VALOR_LETRAS")
	private String valorLetra;
	
	@Column (name= "DESCRIPCION_EGRESO")
	private String descripcionEgreso;
	
	@Column (name= "OBSERVACIONES_EGRESO")
	private String observacionesEgreso;

	
	
	public Egresos() {
		super();
	}

	public int getIdEgreso() {
		return idEgreso;
	}

	public void setIdEgreso(int idEgreso) {
		this.idEgreso = idEgreso;
	}

	public int getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(int idBeneficiario) {
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

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public float getValorEgreso() {
		return valorEgreso;
	}

	public void setValorEgreso(float valorEgreso) {
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

	@Override
	public String toString() {
		return "Egresos [idEgreso=" + idEgreso + ", idBeneficiario=" + idBeneficiario + ", nombreBeneficiario="
				+ nombreBeneficiario + ", direccionBeneficiario=" + direccionBeneficiario + ", telefonoBeneficiario="
				+ telefonoBeneficiario + ", ciudadBeneficiario=" + ciudadBeneficiario + ", mediosPago=" + mediosPago
				+ ", idBanco=" + idBanco + ", fechaEgreso=" + fechaEgreso + ", valorEgreso=" + valorEgreso
				+ ", valorLetra=" + valorLetra + ", descripcionEgreso=" + descripcionEgreso + ", observacionesEgreso="
				+ observacionesEgreso + "]";
	}
	
	
	
}

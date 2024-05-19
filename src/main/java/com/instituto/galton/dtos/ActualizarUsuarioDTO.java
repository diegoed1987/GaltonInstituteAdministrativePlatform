package com.instituto.galton.dtos;

public class ActualizarUsuarioDTO {
	
	private String idUsuario;
	private String emailUsuario;
	private String passwordUsuario;
	private String rolUsuario;
	private String estadoUsuario;
	private String sedeUsuario;
	private String documentoUsuario;
	private String nombreUsuario;
	private String fechaNacimiento;
	private String direccionUsuario;
	private String telefonoUsuario;

	public ActualizarUsuarioDTO() {
		super();
	}

	public ActualizarUsuarioDTO(String idUsuario, String emailUsuario, String passwordUsuario, String rolUsuario,
			String estadoUsuario, String sedeUsuario, String documentoUsuario, String nombreUsuario,
			String fechaNacimiento, String direccionUsuario, String telefonoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.emailUsuario = emailUsuario;
		this.passwordUsuario = passwordUsuario;
		this.rolUsuario = rolUsuario;
		this.estadoUsuario = estadoUsuario;
		this.sedeUsuario = sedeUsuario;
		this.documentoUsuario = documentoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionUsuario = direccionUsuario;
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public String getSedeUsuario() {
		return sedeUsuario;
	}

	public void setSedeUsuario(String sedeUsuario) {
		this.sedeUsuario = sedeUsuario;
	}

	public String getDocumentoUsuario() {
		return documentoUsuario;
	}

	public void setDocumentoUsuario(String documentoUsuario) {
		this.documentoUsuario = documentoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	
	
}

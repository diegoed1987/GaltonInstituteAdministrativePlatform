package com.instituto.galton.dtos;

public class CrearUsuarioDTO {

	private String emailUsuario;
	private String passwordUsuario;
	private String rolUsuario;
	private String estadoUsuario;
	private String documentoUsuario;
	private String nombreUsuario;
	private String fechaNacimiento;
	private String direccionUsuario;
	private String telefonoUsuario;
	private String sedeUsuario;

	public CrearUsuarioDTO() {
		super();
	}
	
	public CrearUsuarioDTO(String emailUsuario, String passwordUsuario, String rolUsuario, String estadoUsuario,
			String documentoUsuario, String nombreUsuario, String fechaNacimiento, String direccionUsuario,
			String telefonoUsuario, String sedeUsuario) {
		super();
		this.emailUsuario = emailUsuario;
		this.passwordUsuario = passwordUsuario;
		this.rolUsuario = rolUsuario;
		this.estadoUsuario = estadoUsuario;
		this.documentoUsuario = documentoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionUsuario = direccionUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.sedeUsuario = sedeUsuario;
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
	public String getSedeUsuario() {
		return sedeUsuario;
	}
	public void setSedeUsuario(String sedeUsuario) {
		this.sedeUsuario = sedeUsuario;
	}
	
	@Override
	public String toString() {
		return "CrearUsuarioDTO [emailUsuario=" + emailUsuario + ", passwordUsuario=" + passwordUsuario
				+ ", rolUsuario=" + rolUsuario + ", estadoUsuario=" + estadoUsuario + ", documentoUsuario="
				+ documentoUsuario + ", nombreUsuario=" + nombreUsuario + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccionUsuario=" + direccionUsuario + ", telefonoUsuario=" + telefonoUsuario + ", sedeUsuario="
				+ sedeUsuario + "]";
	}
	
}

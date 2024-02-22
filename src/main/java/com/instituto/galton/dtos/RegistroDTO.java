package com.instituto.galton.dtos;

public class RegistroDTO {
	
	private String documento;
	private String nombre;
	private String email;
	private String password;
	
	public RegistroDTO() {
		super();
	}

	public RegistroDTO(String documento, String nombre, String email, String password) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegistroDTO [documento=" + documento + ", nombre=" + nombre + ", email=" + email + ", password="
				+ password + "]";
	}
}

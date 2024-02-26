package com.instituto.galton.dtos;

public class EmailDTO {
	
	private String emailTo;
	private String emailSubject;
	private String emailText;
	
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailText() {
		return emailText;
	}
	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}
	
	@Override
	public String toString() {
		return "EmailDTO [emailTo=" + emailTo + ", emailSubject=" + emailSubject + ", emailText=" + emailText + "]";
	}
}

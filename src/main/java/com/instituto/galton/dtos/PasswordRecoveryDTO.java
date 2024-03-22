package com.instituto.galton.dtos;

public class PasswordRecoveryDTO {
	
	private String emailModal;
	
	public PasswordRecoveryDTO(String emailModal) {
		this.emailModal = emailModal;
	}

	public String getEmailModal() {
		return emailModal;
	}

	public void setEmailModal(String emailModal) {
		this.emailModal = emailModal;
	}


}

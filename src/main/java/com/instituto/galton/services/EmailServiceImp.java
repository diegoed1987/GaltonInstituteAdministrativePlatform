package com.instituto.galton.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.instituto.galton.dtos.EmailDTO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImp {
	
	@Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(EmailDTO emailDTO) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
        try {
            helper.setTo(emailDTO.getEmailTo());
            helper.setSubject(emailDTO.getEmailSubject());
            helper.setText(emailDTO.getEmailText(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }
}

package com.ftn.ProjectISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.model.User;

@Service
public class MyMailService {
	
	JavaMailSender javaMailSender;
	
	@Autowired
	public MyMailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	public void sendApprovedEmail(User recipient) throws Exception{
	
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(recipient.getEmail());
		mail.setFrom("projectISA098@gmail.com");
		mail.setSubject("Confirm your registration");
		
		String text = "Please visit link below in order to finish your registration to our site!\n\n";
		text+="http://localhost:4200/confirmation/";
		text+=recipient.getConfirmationKey();

		mail.setText(text);
		
		javaMailSender.send(mail);
	}
	
	public void sendDeclinedEmail(User recipient) throws Exception{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(recipient.getEmail());
		mail.setFrom("projectISA098@gmail.com");
		mail.setSubject("Registration denied!");

		String text = "Admin of our site has denied your registration request!\n\n";
		mail.setText(text);
		
		javaMailSender.send(mail);
	}

}

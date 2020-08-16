package com.ftn.ProjectISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.ProjectISA.model.User;

@Service
public class MyMailService {
	
	JavaMailSender javaMailSender;
	
	@Autowired
	public MyMailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, noRollbackFor=Exception.class, isolation = Isolation.READ_COMMITTED)
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
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, noRollbackFor=Exception.class, isolation = Isolation.READ_COMMITTED)
	public void sendDeclinedEmail(User recipient) throws Exception{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(recipient.getEmail());
		mail.setFrom("projectISA098@gmail.com");
		mail.setSubject("Registration denied!");

		String text = "Admin of our site has denied your registration request!\n\n";
		mail.setText(text);
		
		javaMailSender.send(mail);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, noRollbackFor=Exception.class, isolation = Isolation.READ_COMMITTED)
	public void sendPredefinedExaminationEmail(User recipient) throws Exception{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(recipient.getEmail());
		mail.setFrom("projectISA098@gmail.com");
		mail.setSubject("You have just reserved medical examination!");

		String text = "You have just reserved predefined medical examination!\n\n";
		mail.setText(text);
		
		javaMailSender.send(mail);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, noRollbackFor=Exception.class, isolation = Isolation.READ_COMMITTED)
	public void sendMailToAdminAboutReservation(User recipient) throws Exception{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(recipient.getEmail());
		mail.setFrom("projectISA098@gmail.com");
		mail.setSubject("Client has just reserved a medical examination!");

		String text = "Client has just reserved a medical examination!\n\n";
		mail.setText(text);
		
		javaMailSender.send(mail);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, noRollbackFor=Exception.class, isolation = Isolation.READ_COMMITTED)
	public void sendMailToPatientAboutReservation(User recipient) throws Exception{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(recipient.getEmail());
		mail.setFrom("projectISA098@gmail.com");
		mail.setSubject("You have just reserved a medical examination!");

		String text = "You have just reserved a medical examination!\n\n";
		mail.setText(text);
		
		javaMailSender.send(mail);
	}

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	
	@Autowired
	private Environment env;


	@Async
	public void sendingMailForFreeExaminations(User user)
			throws MailException, InterruptedException {

		Thread.sleep(4000);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		//mail.setFrom(env.getProperty("spring.mail.password"));
		mail.setSubject("Confirmation of appointment scheduling");
		mail.setText("Your examination has been successfully scheduled!");
		javaMailSender.send(mail);
	}

	@Async
	public void sendingMailForVerification(User user) throws MailException,
			InterruptedException {

		Thread.sleep(4000);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		//mail.setFrom(env.getProperty("spring.mail.password"));
		mail.setSubject("Account verification");
		mail.setText("For account verification click on the link http://localhost:11000/users/verify/"
				+ user.getEmail());

		javaMailSender.send(mail);

	}

}

package isa.project.service;

import isa.project.model.Korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;

	/*
	 * Anotacija za oznacavanje asinhronog zadatka Vise informacija na:
	 * https://docs
	 * .spring.io/spring/docs/current/spring-framework-reference/integration
	 * .html#scheduling
	 */
	@Async
	public void sendNotificaitionAsync(Korisnik user) throws MailException,
			InterruptedException {

		// Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(4000);
		System.out.println("E-mail se salje...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomoću asinhronog Spring taska");
		mail.setText("Pozdrav \n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

	@Async
	public void slanjeMejlaZaDostupnePreglede(Korisnik user)
			throws MailException, InterruptedException {

		Thread.sleep(4000);
		System.out.println("E-mail se salje...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Potvrda o zakazivanju pregleda");
		mail.setText("Vas pregled je uspesno zakazan!");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

	@Async
	public void slanjeMejlaZaVerifikaciju(Korisnik user) throws MailException,
			InterruptedException {

		Thread.sleep(4000);
		System.out.println("E-mail se salje...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Verifikacija naloga");
		mail.setText("Za verifikaciju naloga kliknite na link http://localhost:8888/korisnici/verifikuj/"
				+ user.getEmail());

		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

	public void sendNotificaitionSync(Korisnik user) throws MailException,
			InterruptedException {

		// Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(4000);
		System.out.println("E-mail se salje...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomocu asinhronog Spring taska");
		mail.setText("Pozdrav \n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

}

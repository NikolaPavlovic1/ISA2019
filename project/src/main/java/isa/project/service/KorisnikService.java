package isa.project.service;

import isa.project.model.Korisnik;
import isa.project.repository.KorisnikRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

	@Autowired
	KorisnikRepository korisnikRepository;

	// private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public Korisnik saveUser(Korisnik user) {
		return korisnikRepository.save(user);
	}

	public Korisnik getCurrentUser() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return korisnikRepository.findByUsername(principal.toString());
	}

	public Korisnik registrovanje(Korisnik user) {

		return user;
	}

	public Korisnik findByEmail(String email) {
		return korisnikRepository.findOneByEmail(email);
	}

}

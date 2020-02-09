package isa.project.service;

import isa.project.model.Termin;
import isa.project.repository.TerminRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminService {
	
	@Autowired
	private TerminRepository terminRepository;
	
	public Termin saveTermin(Termin termin){
		return terminRepository.save(termin);
	}
	
	public Termin vratiTermin(Date date) {
		return terminRepository.vratiTerminPoDatumu(date);
	}

}

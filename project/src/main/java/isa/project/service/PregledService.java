package isa.project.service;

import java.util.List;

import isa.project.model.Pregled;
import isa.project.repository.PregledRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PregledService {

	@Autowired
	private PregledRepository pregledRepository;

	public List<Pregled> findAll() {
		return pregledRepository.findAll();
	}

	public Pregled savePregled(Pregled pregled) {
		return pregledRepository.save(pregled);
	}

	public List<Pregled> getPregledZakazani() {
		return pregledRepository.getZakazaniPregledi();
	}

	public List<Pregled> getIstorijaPregleda() {
		return pregledRepository.getIstorijaPregleda();
	}

	public List<Pregled> getDostupniPregledi() {
		return pregledRepository.getDostupniPregledi();
	}

	public List<Pregled> getPreglediPoTipu(String tip) {
		return pregledRepository.getPregledPoTipu(tip);
	}

}

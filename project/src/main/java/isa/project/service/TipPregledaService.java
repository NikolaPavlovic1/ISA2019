package isa.project.service;

import java.util.List;

import isa.project.model.TipPregleda;
import isa.project.repository.TipPregledaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipPregledaService {

	@Autowired
	private TipPregledaRepository tipPregledaRepository;

	public List<TipPregleda> sviTipoviPregleda() {
		return tipPregledaRepository.findAll();
	}

}

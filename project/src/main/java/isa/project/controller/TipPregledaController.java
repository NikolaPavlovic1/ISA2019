package isa.project.controller;

import java.util.List;

import isa.project.model.TipPregleda;
import isa.project.service.TipPregledaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "tipovi")
public class TipPregledaController {

	@Autowired
	private TipPregledaService tipPregledaService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<TipPregleda>> getAllTipovi() {

		List<TipPregleda> tipovi = tipPregledaService.sviTipoviPregleda();
		return new ResponseEntity<>(tipovi, HttpStatus.OK);

	}

}

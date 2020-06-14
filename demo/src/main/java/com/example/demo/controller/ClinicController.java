package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClinicSearchDTO;
import com.example.demo.model.Clinic;
import com.example.demo.service.ClinicService;


@RestController
@RequestMapping(value = "clinics")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<Clinic>> getAllExaminations() {
		List<Clinic> clinics = clinicService.findAll();
		return new ResponseEntity<>(clinics, HttpStatus.OK);
	}

	@RequestMapping(value = "/clinicSearch", method = RequestMethod.POST)
	public ClinicSearchDTO clinicSearch(
			@RequestBody ClinicSearchDTO clinic) {
		return clinicService.clinicSearch(clinic);
	}
	
	@RequestMapping(value = "/evaluateClinic/{rating}", method = RequestMethod.POST)
	public Clinic evaluateClinic(
			@RequestBody Clinic clinic, @PathVariable double rating) {
		Clinic c = clinicService.findClinicById(clinic.getId());
		c.addRating(rating);
		c.increaseNumberOfRating();
		c.setRating(c.getSumOfRatings()/c.getNumberOfRatings());
		clinicService.saveClinic(c);
		return clinic;
	}
}

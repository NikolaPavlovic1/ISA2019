package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorSearchDTO;
import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping(value = "doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/doctorSearch", method = RequestMethod.POST)
	public List<Doctor> doctorSearch(@RequestBody DoctorSearchDTO parametar) {
		return doctorService.doctorSearch(parametar);
	}
	
	@RequestMapping(value = "/evaluateDoctor/{rating}", method = RequestMethod.POST)
	public Doctor evaluateDoctor(@RequestBody Doctor doctor, @PathVariable double rating) {
		Doctor d = doctorService.findDoctorById(doctor.getId());
		d.addRating(rating);
		d.increaseNumberOfRating();
		d.setRating(d.getSumOfRatings()/d.getNumberOfRatings());
		doctorService.saveDoctor(d);
		return doctor;
	}
}

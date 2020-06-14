package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Appointment;
import com.example.demo.model.Examination;
import com.example.demo.model.ExaminationStatus;
import com.example.demo.model.User;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.EmailService;
import com.example.demo.service.ExaminationService;
import com.example.demo.service.UserService;


@RestController
@RequestMapping(value = "examinations")
public class ExaminationController {

private Logger logger = LoggerFactory.getLogger(ExaminationController.class);
	
	@Autowired
	private ExaminationService examinationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AppointmentService appointmentService;
		
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<String>> getAllExamination() {
		List<Examination> examinations = examinationService.findAll();
		List<String> types = new ArrayList<>();
		
		for(Examination e : examinations){
			if(!types.contains(e.getType()))
				types.add(e.getType());
		}
		
		return new ResponseEntity<>(types, HttpStatus.OK);
	}
	
	@GetMapping(value = "/scheduled")
	public ResponseEntity<List<Examination>> getScheduled() {
		List<Examination> examinations = examinationService.getScheduledExaminations();
		return new ResponseEntity<>(examinations, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allFreeExaminations")
	public ResponseEntity<List<Examination>> getFreeExaminations() {
		List<Examination> examinations = examinationService.getFreeExamination();
		return new ResponseEntity<>(examinations, HttpStatus.OK);
	}
	
	@GetMapping(value = "/history")
	public ResponseEntity<List<Examination>> getHistory() {	
		List<Examination> examinations = examinationService.getExaminationHistory();
		return new ResponseEntity<>(examinations, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cancel", method=RequestMethod.POST)
	public Examination cancelExamination(@RequestBody Examination examination){
		User current = userService.getCurrentUser();
		examination.setStatus(ExaminationStatus.CANCELED);
		examination.setUser(current);
		examinationService.saveExamination(examination);
		return examination;
	}
	
	@RequestMapping(value="/scheduleFree", method=RequestMethod.POST)
	public ResponseEntity<Examination> scheduleFreeExamination(@RequestBody Examination examination){
		User current = userService.getCurrentUser();
		Appointment newApp = new Appointment();
		examination.setStatus(ExaminationStatus.SCHEDULED);
		examination.setUser(current);
		
		if(examination.getTime() != null) {
			newApp= appointmentService.getAppointment(examination.getTime());
		} else {
			newApp = examination.getTempTime();
		}
		newApp.setReserved(true);
		if(examination.getAppointment().before(examination.getDoctor().getVacationTo()) && examination.getAppointment().after(examination.getDoctor().getVacationFrom())) {
			return new ResponseEntity<Examination>(HttpStatus.BAD_REQUEST);
		} else {
			newApp.setDoctor(examination.getDoctor());
			
			examination.setTime(newApp.getAppointment());
			
			appointmentService.saveAppointment(newApp);
			examinationService.saveExamination(examination);
			
			try {
				emailService.sendingMailForFreeExaminations(current);
			}catch( Exception e ){
				logger.info("Error: " + e.getMessage());
			}
			return new ResponseEntity<>(examination, HttpStatus.OK);
		}
	}
}

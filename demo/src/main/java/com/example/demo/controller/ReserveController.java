package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Appointment;
import com.example.demo.model.Examination;
import com.example.demo.model.ExaminationStatus;
import com.example.demo.model.User;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.ExaminationService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "scheduling")
public class ReserveController {

	@Autowired
	private ExaminationService examinationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppointmentService appointmentService;
	
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
			return new ResponseEntity<>(examination, HttpStatus.OK);
		}
	}
}

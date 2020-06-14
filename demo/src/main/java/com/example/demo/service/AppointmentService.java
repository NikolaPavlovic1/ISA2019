package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;


@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment saveAppointment(Appointment appointment){
		return appointmentRepository.save(appointment);
	}
	
	public Appointment getAppointment(Date date) {
		return appointmentRepository.getAppointmentByDate(date);
	}
}

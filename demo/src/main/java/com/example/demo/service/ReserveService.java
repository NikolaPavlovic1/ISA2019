package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Examination;
import com.example.demo.repository.ExaminationRepository;

@Service
public class ReserveService {

	@Autowired
	private ExaminationRepository examinationRepository;
	
	public Examination saveExamination(Examination examination) {
		return examinationRepository.save(examination);
	}
	
	public void reserveExamination(Examination examination) {
		Examination e = examinationRepository.getOne(examination.getId());
		e.setAppointment(examination.getAppointment());
		examinationRepository.save(e);
	}
}

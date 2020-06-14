package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Examination;
import com.example.demo.repository.ExaminationRepository;


@Service
public class ExaminationService {

	@Autowired
	private ExaminationRepository examinationRepository;

	
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public Examination saveExamination(Examination examination) {
		return examinationRepository.save(examination);
	}
	
	public List<Examination> findAll() {
		return examinationRepository.findAll();
	}
	
	public List<Examination> getExaminationsByType(String type) {
		return examinationRepository.getExaminationByType(type);
	}
	
	public List<Examination> getExaminationHistory() {
		return examinationRepository.getExaminationHistory();
	}

	public List<Examination> getFreeExamination() {
		return examinationRepository.getFreeExaminations();
	}

	public List<Examination> getScheduledExaminations() {
		return examinationRepository.getScheduledExaminations();
	}

}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ExaminationType;
import com.example.demo.repository.ExaminationTypeRepository;


@Service
public class ExaminationTypeService {

	@Autowired
	private ExaminationTypeRepository examinationTypeRepository;

	public List<ExaminationType> getAllTypes() {
		return examinationTypeRepository.findAll();
	}
}

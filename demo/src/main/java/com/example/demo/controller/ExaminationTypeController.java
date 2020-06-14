package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExaminationType;
import com.example.demo.service.ExaminationTypeService;


@RestController
@RequestMapping(value = "types")
public class ExaminationTypeController {

	@Autowired
	private ExaminationTypeService examinationTypeService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<ExaminationType>> getAllTypes() {

		List<ExaminationType> types = examinationTypeService.getAllTypes();
		return new ResponseEntity<>(types, HttpStatus.OK);

	}
}

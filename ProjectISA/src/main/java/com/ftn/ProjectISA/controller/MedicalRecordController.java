package com.ftn.ProjectISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.ProjectISA.dto.MedicalRecordDTO;
import com.ftn.ProjectISA.service.MedicalRecordService;

@Controller
@RequestMapping(value = "api/medical-record")
public class MedicalRecordController {

	@Autowired
	MedicalRecordService medicalRecordService;

	@GetMapping(value = "all")
	public ResponseEntity<List<MedicalRecordDTO>> findAllMedicalRecords() {
		List<MedicalRecordDTO> retVal = medicalRecordService.findAllMedicalRecords();
		return new ResponseEntity<List<MedicalRecordDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<MedicalRecordDTO> findMedicalRecord(@PathVariable Long id) { 
		MedicalRecordDTO retVal = medicalRecordService.findMedicalRecord(id);
		return new ResponseEntity<MedicalRecordDTO>(retVal, HttpStatus.OK);
	}

	
}

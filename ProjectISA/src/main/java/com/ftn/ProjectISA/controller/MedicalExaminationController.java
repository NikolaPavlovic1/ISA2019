package com.ftn.ProjectISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.ProjectISA.dto.MedicalExaminationDTO;
import com.ftn.ProjectISA.dto.TypeDurationDTO;
import com.ftn.ProjectISA.service.MedicalExaminationService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/medical-examination")
public class MedicalExaminationController {

	@Autowired
	MedicalExaminationService medicalExaminationService;

	@GetMapping(value = "all")
	public ResponseEntity<List<MedicalExaminationDTO>> findAllMedicalExaminations() {
		List<MedicalExaminationDTO> retVal = medicalExaminationService.findAllMedicalExaminations();
		return new ResponseEntity<List<MedicalExaminationDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "history/{userId}")
	public ResponseEntity<List<MedicalExaminationDTO>> medicalExaminationsUserHistory(@PathVariable Long userId) {
		List<MedicalExaminationDTO> retVal = medicalExaminationService.medicalExaminationsUserHistory(userId);
		return new ResponseEntity<List<MedicalExaminationDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<MedicalExaminationDTO> findMedicalExamination(@PathVariable Long id) { 
		MedicalExaminationDTO retVal = medicalExaminationService.findMedicalExamination(id);
		return new ResponseEntity<MedicalExaminationDTO>(retVal, HttpStatus.OK);
	}

	
	@PostMapping(consumes = "application/json") 
	public ResponseEntity<MedicalExaminationDTO> addMedicalExamination(
			@RequestBody MedicalExaminationDTO medicalExaminationDTO){
		MedicalExaminationDTO retVal = medicalExaminationService.addMedicalExamination(medicalExaminationDTO);
		return new ResponseEntity<MedicalExaminationDTO>(retVal, HttpStatus.OK); 
	}
	  	  
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> deleteMedicalExamination(@PathVariable Long id){ 
		medicalExaminationService.deleteMedicalExamination(id);
		return new ResponseEntity<>("Medical examination deleted successfully", HttpStatus.OK); 
	}
	
	@PostMapping(value="addTypeDuration") 
	public ResponseEntity<?> addTypeDuration(@RequestBody TypeDurationDTO tddto){
		medicalExaminationService.addTypeDuration(tddto.getType(),tddto.getDuration());
		return new ResponseEntity<>("Type duration added successfully", HttpStatus.OK); 
	}

}

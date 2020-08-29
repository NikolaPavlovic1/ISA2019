package com.ftn.ProjectISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.ProjectISA.dto.MedicalExaminationDTO;
import com.ftn.ProjectISA.dto.MedicalExaminationHistoryDTO;
import com.ftn.ProjectISA.dto.TypeDurationDTO;
import com.ftn.ProjectISA.service.MedicalExaminationService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/medical-examination")
public class MedicalExaminationController {

	@Autowired
	MedicalExaminationService medicalExaminationService;

	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping(value = "all")
	public ResponseEntity<List<MedicalExaminationDTO>> findAllMedicalExaminations() {
		List<MedicalExaminationDTO> retVal = medicalExaminationService.findAllMedicalExaminations();
		return new ResponseEntity<List<MedicalExaminationDTO>>(retVal, HttpStatus.OK);
	}
	
	//ova
	@PreAuthorize("hasAuthority('PATIENT')")
	@GetMapping(value = "history/{userId}")
	public ResponseEntity<List<MedicalExaminationHistoryDTO>> medicalExaminationsUserHistory(@PathVariable Long userId) {
		System.out.println("USao");
		List<MedicalExaminationHistoryDTO> retVal = medicalExaminationService.medicalExaminationsUserHistory(userId);
		return new ResponseEntity<List<MedicalExaminationHistoryDTO>>(retVal, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('PATIENT')")
	@GetMapping(value = "future/{userId}")
	public ResponseEntity<List<MedicalExaminationHistoryDTO>> medicalExaminationsUserReservations(@PathVariable Long userId) {
		List<MedicalExaminationHistoryDTO> retVal = medicalExaminationService.medicalExaminationsUserReservations(userId);
		return new ResponseEntity<List<MedicalExaminationHistoryDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<MedicalExaminationDTO> findMedicalExamination(@PathVariable Long id) { 
		MedicalExaminationDTO retVal = medicalExaminationService.findMedicalExamination(id);
		return new ResponseEntity<MedicalExaminationDTO>(retVal, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('PATIENT')")
	@PostMapping(consumes = "application/json") 
	public ResponseEntity<MedicalExaminationDTO> addMedicalExamination(
			@RequestBody MedicalExaminationDTO medicalExaminationDTO){
		MedicalExaminationDTO retVal = medicalExaminationService.addMedicalExamination(medicalExaminationDTO);
		return new ResponseEntity<MedicalExaminationDTO>(retVal, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping(consumes = "application/json", value = "/predefined") 
	public ResponseEntity<MedicalExaminationHistoryDTO> addPredefinedMedicalExamination(
			@RequestBody MedicalExaminationDTO medicalExaminationDTO){
		MedicalExaminationHistoryDTO retVal = medicalExaminationService.addPredefinedMedicalExamination(medicalExaminationDTO);
		return new ResponseEntity<MedicalExaminationHistoryDTO>(retVal, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('PATIENT')")
	@GetMapping(value = "/predefined/{clinicId}") 
	public ResponseEntity<List<MedicalExaminationHistoryDTO>> getPredefinedMedicalExaminations(@PathVariable Long clinicId){
		List<MedicalExaminationHistoryDTO> retVal = medicalExaminationService.getPredefinedMedicalExaminations(clinicId);
		return new ResponseEntity<List<MedicalExaminationHistoryDTO>>(retVal, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('PATIENT')")
	@GetMapping(value = "/predefined/{patientId}/{examinationId}") 
	public ResponseEntity<Boolean> reservePredefinedMedicalExamination(
			@PathVariable Long patientId, @PathVariable Long examinationId){
		Boolean retVal = medicalExaminationService.reservePredefinedMedicalExamination(patientId,examinationId);
		return new ResponseEntity<Boolean>(retVal, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> deleteMedicalExamination(@PathVariable Long id){ 
		medicalExaminationService.deleteMedicalExamination(id);
		return new ResponseEntity<>("Medical examination deleted successfully", HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping(value="addTypeDuration") 
	public ResponseEntity<?> addTypeDuration(@RequestBody TypeDurationDTO tddto){
		medicalExaminationService.addTypeDuration(tddto.getType(),tddto.getDuration());
		return new ResponseEntity<>("Type duration added successfully", HttpStatus.OK); 
	}

}

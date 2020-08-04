package com.ftn.ProjectISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.ProjectISA.dto.DiseaseDTO;
import com.ftn.ProjectISA.service.DiseaseService;

@Controller
@RequestMapping(value = "api/disease")
public class DiseaseController {

	@Autowired
	DiseaseService diseaseService;

	@GetMapping(value = "all")
	public ResponseEntity<List<DiseaseDTO>> findAllDiseases() {
		List<DiseaseDTO> retVal = diseaseService.findAllDiseases();
		return new ResponseEntity<List<DiseaseDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<DiseaseDTO> findDisease(@PathVariable Long id) { 
		DiseaseDTO retVal = diseaseService.findDisease(id); 
		return new ResponseEntity<DiseaseDTO>(retVal, HttpStatus.OK); }

	//@PreAuthorize("ADMINISTRATOR")
	@PostMapping(consumes = "application/json") 
	public ResponseEntity<DiseaseDTO> addDisease(@RequestBody DiseaseDTO diseaseDTO){
		DiseaseDTO retVal = diseaseService.addDisease(diseaseDTO);
		return new ResponseEntity<DiseaseDTO>(retVal, HttpStatus.OK); 
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> deleteDisease(@PathVariable Long id){ 
		diseaseService.deleteDisease(id);
	    return new ResponseEntity<>("Disease deleted successfully", HttpStatus.OK); 
	}
}

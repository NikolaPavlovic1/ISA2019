package com.ftn.ProjectISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.ProjectISA.model.Disease;
import com.ftn.ProjectISA.service.DiseaseService;

@Controller
@RequestMapping(value = "api/disease")
public class DiseaseController {

	@Autowired
	DiseaseService diseaseService;

	@GetMapping(value = "all")
	public ResponseEntity<List<Disease>> findAllDiseases() {
		List<Disease> retVal = diseaseService.findAllDiseases();
		return new ResponseEntity<List<Disease>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<Disease> findDisease(@PathVariable Long id) { 
		Disease retVal = diseaseService.findDisease(id); 
		return new ResponseEntity<Disease>(retVal, HttpStatus.OK); }

	@PreAuthorize("ADMINISTRATOR")
	@PostMapping(consumes = "application/json") 
	public ResponseEntity<Disease> addDisease(@RequestBody Disease diseaseDTO){
		Disease retVal = diseaseService.addDisease(diseaseDTO);
		return new ResponseEntity<Disease>(retVal, HttpStatus.OK); 
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> deleteDisease(@PathVariable Long id){ 
		diseaseService.deleteDisease(id);
	    return new ResponseEntity<>("Disease deleted successfully", HttpStatus.OK); 
	}
}

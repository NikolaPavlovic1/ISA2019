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

import com.ftn.ProjectISA.dto.ClinicDTO;
import com.ftn.ProjectISA.dto.FilterClinicsDTO;
import com.ftn.ProjectISA.dto.FilterDoctorsDTO;
import com.ftn.ProjectISA.dto.PricelistItemDTO;
import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.service.ClinicService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/clinic")
public class ClinicController {

	@Autowired
	ClinicService clinicService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ClinicDTO>> findAllClinics() {
		List<ClinicDTO> retVal = clinicService.findAllClinics();
		return new ResponseEntity<List<ClinicDTO>>(retVal, HttpStatus.OK);
	}
	
	//ova
	@PostMapping(consumes = "application/json", value = "/filterClinics")
	public ResponseEntity<List<ClinicDTO>> filterClinics(@RequestBody FilterClinicsDTO filterClinicsDTO) {
		List<ClinicDTO> retVal = clinicService.filterClinics(filterClinicsDTO);
		return new ResponseEntity<List<ClinicDTO>>(retVal, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json", value = "/filterDoctors")
	public ResponseEntity<List<UserDTO>> filterDoctors(@RequestBody FilterDoctorsDTO filterDoctorsDTO) {
		List<UserDTO> retVal = clinicService.filteredDoctorsInClinic(filterDoctorsDTO);
		return new ResponseEntity<List<UserDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<ClinicDTO> findClinic(@PathVariable Long id) { 
		ClinicDTO retVal = clinicService.findClinic(id); 
		return new ResponseEntity<ClinicDTO>(retVal, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping(consumes = "application/json") 
	public ResponseEntity<ClinicDTO> addClinic(@RequestBody ClinicDTO clinicDTO){
		ClinicDTO retVal = clinicService.addClinic(clinicDTO); 
		return new ResponseEntity<ClinicDTO>(retVal, HttpStatus.OK); 
	}
	  
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> deleteClinic(@PathVariable Long id){ 
		clinicService.deleteClinic(id);
		return new ResponseEntity<>("Clinic deleted successfully", HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping(consumes = "application/json", value = "/addPriceListItem")
	public ResponseEntity<PricelistItemDTO> addPriceListItem(@RequestBody PricelistItemDTO item) {
		PricelistItemDTO retVal = clinicService.addPricelistItem(item);
		return new ResponseEntity<PricelistItemDTO>(retVal, HttpStatus.OK);
	}
}

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

import com.ftn.ProjectISA.dto.MedicalRoomDTO;
import com.ftn.ProjectISA.service.MedicalRoomService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/medical-room")
public class MedicalRoomController {
	
	@Autowired
	MedicalRoomService roomService;
	
	@GetMapping(value = "all")
	public ResponseEntity<List<MedicalRoomDTO>> findAllMedicalRooms() {
		List<MedicalRoomDTO> retVal = roomService.findAllRooms();
		return new ResponseEntity<List<MedicalRoomDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<MedicalRoomDTO> findMedicalRoom(@PathVariable Long id) { 
		MedicalRoomDTO retVal = roomService.findMedicalRoom(id); 
		return new ResponseEntity<MedicalRoomDTO>(retVal, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping(consumes = "application/json") 
	public ResponseEntity<MedicalRoomDTO> addMedicalRoom(@RequestBody MedicalRoomDTO medicalRoomDTO){
		MedicalRoomDTO retVal = roomService.addMedicalRoom(medicalRoomDTO); 
		return new ResponseEntity<MedicalRoomDTO>(retVal, HttpStatus.OK); 
	}
	  
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> deleteMedicalRoom(@PathVariable Long id){ 
		roomService.deleteMedicalRoom(id);
		return new ResponseEntity<>("Medical room deleted successfully", HttpStatus.OK); 
	}

}

package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.PatientDTO;
import com.ftn.ProjectISA.model.Patient;
import com.ftn.ProjectISA.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	public PatientDTO registerPatient(PatientDTO patientDTO) {
		Patient p = new Patient(patientDTO);

		patientRepository.save(p);
		return patientDTO;
	}

	public List<PatientDTO> findAllPatients() {

		List<PatientDTO> patientDTOs = new ArrayList<PatientDTO>();
		
		List<Patient> patients = patientRepository.findAll();
		
		for(Patient p : patients)
			patientDTOs.add(new PatientDTO(p));
		
		return patientDTOs;
	}

	public PatientDTO findPatient(Long id) {
		PatientDTO retVal = new PatientDTO(patientRepository.getOne(id));
		return retVal;
	}

	public PatientDTO updatePatient(PatientDTO patient) {
		Patient p = patientRepository.getOne(patient.getId());
		p.setName(patient.getName());
		p.setLastName(patient.getLastName());
		p.setEmail(patient.getEmail());
		p.setPhoneNumber(patient.getPhoneNumber());
		p.setInsuranceNumber(patient.getInsuranceNumber());
		
		return new PatientDTO(patientRepository.save(p));
	}

	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
}

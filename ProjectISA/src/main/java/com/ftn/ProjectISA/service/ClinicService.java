package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.ClinicDTO;
import com.ftn.ProjectISA.dto.FilterClinicsDTO;
import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.repository.ClinicRepository;

@Service
public class ClinicService {
	
	@Autowired
	ClinicRepository clinicRepository;
	
	public ClinicDTO addClinic(ClinicDTO c) {
		Clinic clinic = new Clinic(c);
		
		clinicRepository.save(clinic);
		return c;
	}

	public List<ClinicDTO> findAllClinics() {

		List<ClinicDTO> clinicsDtos = new ArrayList<ClinicDTO>();
		
		List<Clinic> clinics = clinicRepository.findAll();
		
		for(Clinic c : clinics)
			clinicsDtos.add(new ClinicDTO(c));
		
		return clinicsDtos;
	}
	
	public List<ClinicDTO> filterClinics(FilterClinicsDTO filterClinicsDTO) {

		List<ClinicDTO> clinicsDtos = new ArrayList<ClinicDTO>();
		
		List<Clinic> clinics = clinicRepository.findAll();
		
		/*for(Clinic c : clinics) {
			if
		}
			clinicsDtos.add(new ClinicDTO(c));
		*/
		return clinicsDtos;
	}

	public ClinicDTO findClinic(Long id) {
		ClinicDTO retVal = new ClinicDTO(clinicRepository.getOne(id));
		return retVal;
	}
	
	public void deleteClinic(Long id) {
		clinicRepository.deleteById(id);
	}
	
	
}

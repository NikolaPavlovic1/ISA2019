package com.ftn.ProjectISA.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.ClinicDTO;
import com.ftn.ProjectISA.dto.FilterClinicsDTO;
import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.TypeDuration;
import com.ftn.ProjectISA.model.User;
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
		
		//LocalDateTime ldt = LocalDateTime.
		List<ClinicDTO> filteredClinics = new ArrayList<ClinicDTO>();
		
		List<Clinic> clinics = clinicRepository.findAll();
		
		for(Clinic clinic : clinics) {
			boolean match = false;
			for(User doctor: clinic.getDoctors()) {
				boolean type = false;
				boolean date = true;
				
				for(TypeDuration td: doctor.getTypesOfExamination()) {
					if(td.getType().equals(filterClinicsDTO.getType())) {
						type = true;
						System.out.println("usao");
					}
				}
				for(MedicalExamination me : doctor.getDoctorsScheduledExaminations()) {
					Date d = Date.from(me.getStartDateTime().atZone(ZoneId.systemDefault()).toInstant());
					System.out.println(d);
					System.out.println(filterClinicsDTO.getDate());
					if(d == filterClinicsDTO.getDate()) {
						date = false;
						System.out.println("USAO");
					}
				}
				
				if(type && date) {
					match = true;
				}
				
				System.out.println("---------------");
			}
			
			if(match) {
				filteredClinics.add(new ClinicDTO(clinic));
			}
		}
		
		
		return filteredClinics;
	}

	public ClinicDTO findClinic(Long id) {
		ClinicDTO retVal = new ClinicDTO(clinicRepository.getOne(id));
		return retVal;
	}
	
	public void deleteClinic(Long id) {
		clinicRepository.deleteById(id);
	}
	
	
}

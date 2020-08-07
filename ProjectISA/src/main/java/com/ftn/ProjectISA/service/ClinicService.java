package com.ftn.ProjectISA.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.ClinicDTO;
import com.ftn.ProjectISA.dto.FilterClinicsDTO;
import com.ftn.ProjectISA.dto.FilterDoctorsDTO;
import com.ftn.ProjectISA.dto.PricelistItemDTO;
import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.PricelistItem;
import com.ftn.ProjectISA.model.TypeDuration;
import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.ClinicRepository;
import com.ftn.ProjectISA.repository.PricelistItemRepository;

@Service
public class ClinicService {
	
	@Autowired
	ClinicRepository clinicRepository;
	
	@Autowired
	PricelistItemRepository pricelistItemRepository;
	
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
	
	public List<UserDTO> filteredDoctorsInClinic(FilterDoctorsDTO filterDoctorsDTO) {
		
		Clinic clinic = this.clinicRepository.getOne(filterDoctorsDTO.getClinicId());
		List<UserDTO> filteredDoctors = new ArrayList<UserDTO>();
		
			for(User doctor: clinic.getDoctors()) {
				boolean type = false;
				boolean date = true;
				
				//if(filterDoctorsDTO.gett)
				for(TypeDuration td: doctor.getTypesOfExamination()) {
					if(td.getType().equals(filterDoctorsDTO.getType())) {
						type = true;
					}
				}
				
				for(MedicalExamination me : doctor.getDoctorsScheduledExaminations()) {
					Date d = Date.from(me.getStartDateTime().atZone(ZoneId.systemDefault()).toInstant());
					if(d == filterDoctorsDTO.getDate()) {
						date = false;
						System.out.println("USAO");
					}
				}
				
				if(type && date) {
					filteredDoctors.add(new UserDTO(doctor));
				}
			}
			
			return filteredDoctors;
	}

	public ClinicDTO findClinic(Long id) {
		ClinicDTO retVal = new ClinicDTO(clinicRepository.getOne(id));
		return retVal;
	}
	
	public void deleteClinic(Long id) {
		clinicRepository.deleteById(id);
	}
	
	public PricelistItemDTO addPricelistItem(PricelistItemDTO pricelistItemDTO) {
		Clinic clinic = this.clinicRepository.getOne(pricelistItemDTO.getClinicId());
		PricelistItem item = new PricelistItem(pricelistItemDTO.getTypeOfExamination(),pricelistItemDTO.getPrice());
		item.setClinic(clinic);
		this.pricelistItemRepository.save(item);
		pricelistItemDTO.setId(item.getId());
		return pricelistItemDTO;
	}
	
	
}

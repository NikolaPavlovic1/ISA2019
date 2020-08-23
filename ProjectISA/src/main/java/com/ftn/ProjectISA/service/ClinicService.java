package com.ftn.ProjectISA.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

@Transactional(readOnly = true)
@Service
public class ClinicService {
	
	@Autowired
	ClinicRepository clinicRepository;
	
	@Autowired
	PricelistItemRepository pricelistItemRepository;
	
	@Transactional(readOnly = false)
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
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public List<ClinicDTO> filterClinics(FilterClinicsDTO filterClinicsDTO) {
		
		List<ClinicDTO> filteredClinics = new ArrayList<ClinicDTO>();
		List<Clinic> clinics = clinicRepository.findAll();
		
		for(Clinic clinic : clinics) {
			boolean match = false;
			for(User doctor: clinic.getDoctors()) {
				boolean type = false;
				boolean date = true;
				
				if(filterClinicsDTO.getType() != null) {
					for(TypeDuration td: doctor.getTypesOfExamination()) {
						if(td.getType().equals(filterClinicsDTO.getType())) {
							type = true;
						}
					}	
				} else {
					type = true;
				}
				
				if(filterClinicsDTO.getDate() != null) {
					for(MedicalExamination me : doctor.getDoctorsScheduledExaminations()) {
						Date d = Date.from(me.getStartDateTime().atZone(ZoneId.systemDefault()).toInstant());
						Calendar cal1 = Calendar.getInstance();
						Calendar cal2 = Calendar.getInstance();
						cal1.setTime(d);
						cal2.setTime(filterClinicsDTO.getDate());
						boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
						                  cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
						if(sameDay) {
							date = false;
						}
					}
				}
				
				
				if(type && date) {
					match = true;
				}
				
			}
			
			if(match) {
				filteredClinics.add(new ClinicDTO(clinic));
			}
		}
		
		
		return filteredClinics;
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public List<UserDTO> filteredDoctorsInClinic(FilterDoctorsDTO filterDoctorsDTO) {
		
		Clinic clinic = this.clinicRepository.getOne(filterDoctorsDTO.getClinicId());
		List<UserDTO> filteredDoctors = new ArrayList<UserDTO>();
		
			for(User doctor: clinic.getDoctors()) {
				boolean type = false;
				boolean date = true;
				boolean other = true;
				
				if(filterDoctorsDTO.getType() == null) {
					type = true;
				} else {
					for(TypeDuration td: doctor.getTypesOfExamination()) {
						if(td.getType().equals(filterDoctorsDTO.getType())) {
							type = true;
						}
					}	
				}
				
				if(filterDoctorsDTO.getDate() != null) {
					for(MedicalExamination me : doctor.getDoctorsScheduledExaminations()) {
						Date d = Date.from(me.getStartDateTime().atZone(ZoneId.systemDefault()).toInstant());
						Calendar cal1 = Calendar.getInstance();
						Calendar cal2 = Calendar.getInstance();
						cal1.setTime(d);
						cal2.setTime(filterDoctorsDTO.getDate());
						boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
						                  cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
						if(sameDay) {
							date = false;
						}
					}
				}
				
				if(filterDoctorsDTO.getFirstName()!= null) {
					if(!doctor.getName().equals(filterDoctorsDTO.getFirstName())) {
						other = false;
					}
				}
				
				if(filterDoctorsDTO.getLastName()!= null) {
					if(!doctor.getLastName().equals(filterDoctorsDTO.getLastName())) {
						other = false;
					}
				}
				
				if(filterDoctorsDTO.getRate() > 0) {
					/*if(doctor.getRate() != filterDoctorsDTO.getRate()) {
						other = false;
					}*/
				}
				
				
				if(type && date && other) {
					filteredDoctors.add(new UserDTO(doctor));
				}
			}
			
			return filteredDoctors;
	}

	public ClinicDTO findClinic(Long id) {
		ClinicDTO retVal = new ClinicDTO(clinicRepository.getOne(id));
		return retVal;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void deleteClinic(Long id) {
		clinicRepository.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public PricelistItemDTO addPricelistItem(PricelistItemDTO pricelistItemDTO) {
		Clinic clinic = this.clinicRepository.getOne(pricelistItemDTO.getClinicId());
		PricelistItem item = new PricelistItem(pricelistItemDTO.getTypeOfExamination(),pricelistItemDTO.getPrice());
		item.setClinic(clinic);
		this.pricelistItemRepository.save(item);
		pricelistItemDTO.setId(item.getId());
		return pricelistItemDTO;
	}
	
	
}

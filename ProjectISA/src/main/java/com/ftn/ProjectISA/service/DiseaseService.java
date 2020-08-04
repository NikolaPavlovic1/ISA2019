package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.DiseaseDTO;
import com.ftn.ProjectISA.model.Disease;
import com.ftn.ProjectISA.model.MedicalRecord;
import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.DiseaseRepository;
import com.ftn.ProjectISA.repository.UserRepository;

@Service
public class DiseaseService {

	@Autowired
	DiseaseRepository diseaseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<DiseaseDTO> findAllDiseases() {
		
		List<Disease> diseases = diseaseRepository.findAll();
		List<DiseaseDTO> diseasesDTO = new ArrayList<>();
		for(Disease d : diseases) {
			diseasesDTO.add(new DiseaseDTO(d));
		}
		
		return diseasesDTO;
	}

	public DiseaseDTO findDisease(Long id) {
		Disease retVal = diseaseRepository.getOne(id);
		return new DiseaseDTO(retVal);
	}
	
	public DiseaseDTO addDisease(DiseaseDTO d) {
		User user = this.userRepository.getOne(d.getPatientId());
		MedicalRecord medicalRecord = user.getMedicalRecord();
		
		Disease disease = new Disease();
		disease.setName(d.getName());
		disease.getMedicalRecords().add(medicalRecord);
		diseaseRepository.save(disease);
		return d;
	}
	
	public void deleteDisease(Long id) {
		diseaseRepository.deleteById(id);
	}
}

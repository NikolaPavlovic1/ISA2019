package com.ftn.ProjectISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.model.Disease;
import com.ftn.ProjectISA.repository.DiseaseRepository;

@Service
public class DiseaseService {

	@Autowired
	DiseaseRepository diseaseRepository;
	
	public List<Disease> findAllDiseases() {

		List<Disease> diseases = diseaseRepository.findAll();
		
		return diseases;
	}

	public Disease findDisease(Long id) {
		Disease retVal = diseaseRepository.getOne(id);
		return retVal;
	}
	
	public Disease addDisease(Disease d) {
		Disease disease = new Disease();
		disease.setName(d.getName());
		return diseaseRepository.save(disease);
	}
	
	public void deleteDisease(Long id) {
		diseaseRepository.deleteById(id);
	}
}

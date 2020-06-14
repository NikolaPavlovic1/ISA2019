package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClinicDTO;
import com.example.demo.dto.ClinicSearchDTO;
import com.example.demo.model.Clinic;
import com.example.demo.model.Examination;
import com.example.demo.repository.ClinicRepository;
import com.example.demo.repository.ExaminationRepository;


@Service
public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;

	@Autowired
	private ExaminationRepository examinationRepository;

	public Clinic findClinicById(long id) {
		return clinicRepository.findOneById(id);
	}
	
	public void saveClinic(Clinic c) {
		clinicRepository.save(c);
	}
	
	public ClinicSearchDTO clinicSearch(ClinicSearchDTO clinicDTO) {

		List<Clinic> list = new ArrayList<>();
		List<ClinicDTO> listDTO = new ArrayList<>();
		ClinicSearchDTO result = new ClinicSearchDTO();
		double price = 0;

		List<Examination> examinations = examinationRepository.getExaminationByType(clinicDTO
				.getExaminationType());

		for (Examination e : examinations) {
			price = e.getTypeOfExamination().getPrice();
			Clinic temp = e.getDoctor().getClinic();
			if (!list.contains(temp)) {
				list.add(temp);
			}

		}

		if (clinicDTO.getExaminationPrice() != 0) {
			list.removeIf(n -> (n.getRating() > clinicDTO.getExaminationPrice()));
		}

		if (clinicDTO.getClinicLocation() != "") {
			list.removeIf(n -> (!n.getCity().equalsIgnoreCase(
					clinicDTO.getClinicLocation())));
		}

		result.setClinics(list);
		result.setExaminationPrice(price);
		result.setClinicsDTO(listDTO);

		return result;
	}
	
	public List<Clinic> findAll() {
		return clinicRepository.findAll();
	}
}

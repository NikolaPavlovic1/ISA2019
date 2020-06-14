package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorSearchDTO;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;


@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public void saveDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}
	
	public Doctor findDoctorById(long id) {
		return doctorRepository.findOneById(id);
	}

	public List<Doctor> doctorSearch(DoctorSearchDTO doctorDTO) {
		ArrayList<Doctor> list = new ArrayList<>();
		list.addAll(doctorDTO.getDoctors());

		if (doctorDTO.getName() != "") {
			list.removeIf(n -> (!n.getName().equalsIgnoreCase(doctorDTO.getName())));
		}

		if (doctorDTO.getSurname() != "") {
			list.removeIf(n -> (!n.getSurname().equalsIgnoreCase(doctorDTO.getSurname())));
		}

		if (doctorDTO.getRating() != 0) {
			list.removeIf(n -> (n.getRating() > doctorDTO.getRating()));
		}

		return list;
	}
	
	
}

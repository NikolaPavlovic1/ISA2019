package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.dto.DoctorSearchDTO;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceTest {

	@Mock
	private DoctorRepository repositoryMock;
	
	@Mock
	private Doctor doctorMock;
	
	@InjectMocks
	private DoctorService doctorService;
	
	@Test
	public void testFindDoctorById() {
		
		Doctor d = new Doctor();
		d.setId((long) 100);
		d.setName("Doctor");
		
		when(repositoryMock.findOneById(100)).thenReturn(d);
		
		Doctor doctor = doctorService.findDoctorById(100);
		
		assertEquals(d.getName(), doctor.getName());
	}
	
	@Test
	public void testDoctorSearch() {
		
		DoctorSearchDTO ddto = new DoctorSearchDTO();
		ddto.setName("Name");
		ddto.setSurname("Surname");
		ddto.setRating(100);
		
		Doctor d = new Doctor();
		d.setId((long) 100);
		d.setName("Name");
		d.setSurname("Surname");
		d.setRating(100);
		
		ArrayList<Doctor> listDoctors = new ArrayList<>();
		listDoctors.add(d);
		ddto.setDoctors(listDoctors);
		
		List<Doctor> list = doctorService.doctorSearch(ddto);
		
		assertEquals(list.get(0).getName(), d.getName());
	}

}

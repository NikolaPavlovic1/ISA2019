package com.example.demo.service;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dto.ClinicDTO;
import com.example.demo.dto.ClinicSearchDTO;
import com.example.demo.model.Clinic;
import com.example.demo.model.Doctor;
import com.example.demo.model.Examination;
import com.example.demo.model.ExaminationType;
import com.example.demo.repository.ClinicRepository;
import com.example.demo.repository.ExaminationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClinicServiceTest {

	@Mock
	private ExaminationRepository repositoryMock;
	
	@Mock
	private ClinicRepository repositoryClinicMock;
	
	@Mock
	private Clinic clinicMock;
	
	@InjectMocks
	private ClinicService clinicService;
	
	@Test
	public void testClinicSearch() {
		
		ClinicSearchDTO cdto = new ClinicSearchDTO();
		cdto.setClinicLocation("Novi Sad");
		cdto.setExaminationPrice(100);
		cdto.setExaminationType("Type");
		
		ExaminationType et = new ExaminationType();
		et.setId((long) 110);
		et.setName("Type");
		et.setPrice(100);
		
		Doctor d = new Doctor();
		d.setId((long) 100);
		Clinic c = new Clinic();
		c.setId((long) 100);
		c.setCity("Novi Sad");
		c.setAddress("Cara Lazara 22");
		c.setDescription("description");
		c.setName("clinic");
		d.setClinic(c);
		Examination e = new Examination();
		e.setId((long) 100);
		e.setClinic(c);
		e.setPrice(100);
		e.setTypeOfExamination(et);
		e.setDoctor(d);
		
		when(repositoryMock.getExaminationByType("Type")).thenReturn(Arrays.asList(e));
		
		ClinicSearchDTO result = clinicService.clinicSearch(cdto);
		
		assertEquals(result.getClinics().get(0).getCity(), "Novi Sad");
		
	}
	
	@Test
	public void testFindClinicById() {
		
		Clinic c = new Clinic();
		c.setId((long) 100);
		c.setAddress("Address");
		
		when(repositoryClinicMock.findOneById(100)).thenReturn(c);
		
		Clinic cl = clinicService.findClinicById(100);
		
		assertEquals(cl.getAddress(), c.getAddress());
	}
}

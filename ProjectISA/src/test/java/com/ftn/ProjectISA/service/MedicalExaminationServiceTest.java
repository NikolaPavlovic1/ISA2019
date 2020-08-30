package com.ftn.ProjectISA.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.repository.MedicalExaminationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class MedicalExaminationServiceTest {
	
	@Autowired
	private MedicalExaminationService medicalExaminationService;

	@MockBean
	private MedicalExaminationRepository medicalExaminationRepositoryMocked;
	
	@Before
	public void setUp() {
		MedicalExamination examination = new MedicalExamination();
		examination.setId(1L);
		examination.setPrice(5000);
		Mockito.when(medicalExaminationRepositoryMocked.getOne(1L)).thenReturn(examination);
		
		
	}
	
	@Test
	public void testGetOne() {
		Long id = 1L;
		MedicalExamination found = this.medicalExaminationRepositoryMocked.getOne(id);
		

		assertEquals(id, found.getId());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetOneNotFound() {
		Long id = 2L;
		MedicalExamination examination = this.medicalExaminationRepositoryMocked.getOne(id);
		

		assertEquals(id, examination.getId());
	}
	
	@Test(expected=NullPointerException.class)
	public void testUserReservations() {
		

//		assertEquals(id, examination.getId());
	}
	
	
	
	

}

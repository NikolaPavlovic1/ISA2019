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

import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.repository.ClinicRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ClinicServiceTest {

	@Autowired
	private ClinicService clinicService;

	@MockBean
	private ClinicRepository clinicRepositoryMocked;

	@Before
	public void setUp() {
		Clinic clinic = new Clinic();
		clinic.setId(1L);
		Mockito.when(clinicRepositoryMocked.getOne(1L)).thenReturn(clinic);
	}
	
	@Test
	public void testGetOne() {
		Long id = 1L;
		Clinic found = this.clinicRepositoryMocked.getOne(id);
		

		assertEquals(id, found.getId());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetOneNotFound() {
		Long id = 2L;
		Clinic clinic = this.clinicRepositoryMocked.getOne(id);
		

		assertEquals(id, clinic.getId());
	}
}

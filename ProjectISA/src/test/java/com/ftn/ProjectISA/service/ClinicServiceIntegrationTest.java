package com.ftn.ProjectISA.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.ftn.ProjectISA.dto.ClinicDTO;
import com.ftn.ProjectISA.model.Address;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class ClinicServiceIntegrationTest {

	@Autowired
	ClinicService clinicService;
	
	 @Test
	 public void testFind_All() {
	     List<ClinicDTO> clinics = clinicService.findAllClinics();
	     assertEquals(3, clinics.size());
	 }
	 
	 @SuppressWarnings("deprecation")
	 @Test
	 public void testGetByID_found() {
	     ClinicDTO clinic = clinicService.findClinic(101L);
	     assertThat(clinic).isNotNull();
	     assertEquals(new Long(101L), clinic.getId());
	}
	 
	 @Test
	 @Transactional
	 @Rollback(true) 
	 public void testAdd() {
	     ClinicDTO clinic = new ClinicDTO();
	     clinic.setAddress(new Address());
	     clinic.setDescription("Test clinic description");
	     clinic.setName("Test clinic name");
	     
	     
	     int sizeBefore = clinicService.findAllClinics().size();
	     ClinicDTO savedClinic = clinicService.addClinic(clinic);
	       
	     assertThat(savedClinic).isNotNull();
	        List<ClinicDTO> clinics = clinicService.findAllClinics();
	        assertThat(clinics).hasSize(sizeBefore + 1);
	        assertEquals(savedClinic.getDescription(),"Test clinic description");
	        assertEquals(savedClinic.getName(),"Test clinic name");

	    }
}

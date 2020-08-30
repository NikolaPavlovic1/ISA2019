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

import com.ftn.ProjectISA.model.Address;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class AddressServiceIntegrationTest {
	
	@Autowired
	AddressService addressService;
	
	 @Test
	 public void testFind_All() {
	     List<Address> addresses = addressService.findAllAddresses();
	     assertEquals(9, addresses.size());
	 }
	 
	 @SuppressWarnings("deprecation")
	 @Test
	 public void testGetByID_found() {
	     Address address = addressService.findAddress(101L);
	     assertThat(address).isNotNull();
	     assertEquals(new Long(101L), address.getId());
	}
	 
	 @Test
	 @Transactional
	 @Rollback(true) 
	 public void testAdd() {
	     Address address = new Address();
	     address.setId(109L);
	     address.setCountry("Srbija");
	     address.setCity("Novi Sad");
	     address.setStreet("Bul. Oslobodjenja");
	     address.setNumber(5);
	     
	     int sizeBefore = addressService.findAllAddresses().size();
	     Address savedAddress = addressService.createAddress(address);
	       
	     assertThat(savedAddress).isNotNull();
	        List<Address> addresses = addressService.findAllAddresses();
	        assertThat(addresses).hasSize(sizeBefore + 1);
	        assertEquals(savedAddress.getId(),address.getId());
	        assertEquals(savedAddress.getCountry(),"Srbija");
	        assertEquals(savedAddress.getCity(),"Novi Sad");
	        assertEquals(savedAddress.getStreet(),"Bul. Oslobodjenja");
	        assertEquals(savedAddress.getNumber(),5);
	        
	    }
	 
	 
	

}

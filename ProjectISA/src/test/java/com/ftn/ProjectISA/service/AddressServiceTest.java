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

import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.repository.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class AddressServiceTest {
	
	@Autowired
	private AddressService addressService;

	@MockBean
	private AddressRepository addressRepositoryMocked;

	@Before
	public void setUp() {
		Address address = new Address();
		address.setId(1L);
		Mockito.when(addressRepositoryMocked.getOne(1L)).thenReturn(address);
	}
	
	@Test
	public void testGetOne() {
		Long id = 1L;
		Address found = this.addressRepositoryMocked.getOne(id);
		

		assertEquals(id, found.getId());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetOneNotFound() {
		Long id = 2L;
		Address address = this.addressRepositoryMocked.getOne(id);
		

		assertEquals(id, address.getId());
	}


}

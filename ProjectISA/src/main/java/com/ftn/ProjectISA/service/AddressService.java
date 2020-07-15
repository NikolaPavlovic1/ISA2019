package com.ftn.ProjectISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public Address createAddress(Address address) {
		Address a = new Address();
		a.setCountry(address.getCountry());
		a.setCity(address.getCity());
		a.setStreet(address.getStreet());
		a.setNumber(address.getNumber());

		return addressRepository.save(a);
	}

	public List<Address> findAllAddresses() {
		return addressRepository.findAll();
	}

	public Address findAddress(long id) {
		Address retVal = addressRepository.getOne(id);
		return retVal;
	}

	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}

	public void deleteAddress(long id) {
		addressRepository.deleteById(id);
	}

}

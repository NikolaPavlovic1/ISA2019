package com.ftn.ProjectISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.repository.AddressRepository;

@Transactional(readOnly = true)
@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Transactional(readOnly = false)
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

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void deleteAddress(long id) {
		addressRepository.deleteById(id);
	}

}

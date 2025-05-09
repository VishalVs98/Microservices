package com.address.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.address.entity.Address;
import com.address.exception.NoAddressException;
import com.address.repository.AddressRepo;
import com.address.response.AddressResponse;

import java.util.Optional;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private ModelMapper mapper;

	public AddressResponse findAddressByAddressId(int addressId) {
		Optional<Address> addressById = addressRepo.findById(addressId);
		AddressResponse addressResponse = mapper.map(addressById, AddressResponse.class);
		return addressResponse;
	}
	public String addAddress(Address address) {
		addressRepo.save(address);
		return "Address ID :"+address.getId()+ " added sucessfully";			
	}
	// if no addressException is checkedException in that case need to handle that in controller
	public String deleteAddressById(int id) throws NoAddressException {
		if(!addressRepo.existsById(id)) {
			
			throw new NoAddressException("Address ID is not present");
			
		}
		
		addressRepo.deleteById(id);
		return "deleted successfully";			
	}

}


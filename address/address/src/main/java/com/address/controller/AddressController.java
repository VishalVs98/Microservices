package com.address.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.entity.Address;
import com.address.exception.NoAddressException;
import com.address.response.AddressResponse;
import com.address.service.AddressService;
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/{addressId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("addressId") int addressId) {
		AddressResponse addressResponse = addressService.findAddressByAddressId(addressId);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> createAddress(@RequestBody Address address) {
		String response=addressService.addAddress(address);	
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id") int addressId){
		String responseString=addressService.deleteAddressById(addressId);
		return ResponseEntity.ok(responseString);
	}

}

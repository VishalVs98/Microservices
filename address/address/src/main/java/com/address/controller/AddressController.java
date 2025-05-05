package com.address.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.address.response.AddressResponse;
import com.address.service.AddressService;
@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	/*@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) {
		AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}*/
	
	@GetMapping("/address/{employeeId}")
	public String getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) {
	//	AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
		return "Address";
	}

}

package com.micro.micro.employeecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.micro.micro.employeeresponse.EmployeeResponse;
import com.micro.micro.employeeservice.EmployeeService;
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	/*@GetMapping("/employees/{id}")
	private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
		EmployeeResponse employee = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}*/
	@GetMapping("/{id}")
	private String getEmployeeDetails(@PathVariable("id") int id) {
	//	EmployeeResponse employee = employeeService.getEmployeeById(id);
		return "employee";
	}
}
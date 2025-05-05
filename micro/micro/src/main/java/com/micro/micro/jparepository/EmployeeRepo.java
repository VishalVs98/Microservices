package com.micro.micro.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.micro.employeeentity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}

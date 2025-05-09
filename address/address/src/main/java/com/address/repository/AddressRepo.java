package com.address.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.address.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

	@Query(
		nativeQuery = true,
		value
		= "SELECT ea.id, ea.city, ea.state FROM microprac.address ea join microprac.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
	Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}


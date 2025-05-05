package com.micro.micro.employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import com.micro.micro.employeeentity.Employee;
import com.micro.micro.employeeresponse.AddressResponse;
import com.micro.micro.employeeresponse.EmployeeResponse;
import com.micro.micro.feignclient.AddressClient;
import com.micro.micro.jparepository.EmployeeRepo;
@Service
public class EmployeeService {
	  @Autowired
	    private EmployeeRepo employeeRepo;
	 
	    @Autowired
	    private ModelMapper mapper;
	 
	    // Spring will create the implementation
	    // for this class
	    // and will inject the bean here (proxy)
	    @Autowired
	    private AddressClient addressClient;
	 
	    public EmployeeResponse getEmployeeById(int id) {
	 
	        Optional<Employee> employee = employeeRepo.findById(id);
	        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
	 
	        // Using FeignClient
	       ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
	        employeeResponse.setAddressResponse(addressResponse.getBody());
	 
	        return employeeResponse;
	    }
	 
}

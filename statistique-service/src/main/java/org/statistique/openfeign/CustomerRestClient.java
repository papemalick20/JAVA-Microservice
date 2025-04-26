package org.statistique.openfeign;

import java.util.List;

//import org.order.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.statistique.entities.Customer;

@FeignClient(name="CUSTOMER-SERVICE", url ="http://localhost:8081")
public interface CustomerRestClient {
	
	@GetMapping(path="/api/customers/{id}") 
	Customer getCustomer(@PathVariable(name="id") String id);
	
	@GetMapping(path="/api/customers")
	List<Customer> allCustomers();

}

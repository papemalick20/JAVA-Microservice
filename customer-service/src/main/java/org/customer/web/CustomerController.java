package org.customer.web;

import java.util.List;
import java.util.UUID;

import org.customer.dto.CustomerRequestDTO;
import org.customer.dto.CustomerResponseDTO;
import org.customer.services.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping(path="/customers")
	public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
		customerRequestDTO.setId(UUID.randomUUID().toString());
		return customerService.save(customerRequestDTO);
		
	}
	@GetMapping(path="/customers")
	 public List<CustomerResponseDTO> allCustomer(){
		 return customerService.listCustomer();
	 }
	

@GetMapping(path="/customers/search")
 public List<CustomerResponseDTO> searchCustomer(@RequestParam(name="keyword", defaultValue = "") String keyword){
	 return customerService.searchCustomer(keyword);
 }
	@GetMapping(path="/customers/{id}")
	public CustomerResponseDTO getCustomerResponseDTO(@PathVariable(name="id")  String customerId) {
		return customerService.getCustomer(customerId);
	}
	
	
	  @PutMapping(path = "/customers/{id}") 
	  public CustomerResponseDTO
	  updateCustomer(@PathVariable(name="id") String id, @RequestBody
	  CustomerRequestDTO customerRequestDTO) { // Assurez-vous que l'ID de l'URL
	  customerRequestDTO.setId(id);
	  
	  return customerService.update(customerRequestDTO); }
	 





}

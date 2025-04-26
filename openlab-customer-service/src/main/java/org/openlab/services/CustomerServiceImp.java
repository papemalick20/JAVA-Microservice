package org.openlab.services;

import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

//import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.openlab.dto.CustomerRequestDTO;
import org.openlab.dto.CustomerResponseDTO;
import org.openlab.entities.Customer;
import org.openlab.mappers.CustomerMapper;
import org.openlab.repository.CustomerRepository;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService{
private CustomerRepository customerRepository;
private CustomerMapper customerMapper;
 
public CustomerServiceImp(CustomerRepository customerRepository, CustomerMapper customerMapper) {
	this.customerRepository=customerRepository;
	this.customerMapper=customerMapper;
}


	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		/*
		       mapping object object* /
		 */
		//Customer customer=new Customer();
		//customer.setId(customerRequestDTO.getId());
		//customer.setName(customerRequestDTO.getName());
		//customer.setEmail(customerRequestDTO.getEmail());
		
		 // customer.setId(UUID.randomUUID().toString());
		
		Customer customer=customerMapper.customerRequestDTOtocustomer(customerRequestDTO);
		  Customer saveCustomer=customerRepository.save(customer);
		  
		  /*
	       mapping object object* /
	      */

		  /*CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
		  customerResponseDTO.setId(saveCustomer.getId());
		  customerResponseDTO.setName(saveCustomer.getName());
		  customerResponseDTO.setEmail(saveCustomer.getEmail());
		  return customerResponseDTO;*/
		  
		  CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerResponseDTO(saveCustomer);
		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO getCustomer(String id) {
		Customer customer=customerRepository.findById(id).get();
		
		return customerMapper.customerToCustomerResponseDTO(customer);
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
		Customer customer=customerMapper.customerRequestDTOtocustomer(customerRequestDTO);
		Customer updateCustomer=customerRepository.save(customer);
		
		return customerMapper.customerToCustomerResponseDTO(updateCustomer);
	}

	@Override
	public List<CustomerResponseDTO> listCustomer() {
		List<Customer> customers=customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOs=
				customers.stream()
				.map(cust->customerMapper
			    .customerToCustomerResponseDTO(cust)).collect(Collectors.toList());
		return customerResponseDTOs;
	}

}

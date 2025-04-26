package org.customer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.customer.dto.CustomerRequestDTO;
import org.customer.dto.CustomerResponseDTO;
import org.customer.entities.Customer;
import org.customer.mappers.CustomerMappers;
import org.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository customerRepository;
	private CustomerMappers customerMappers;
    
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMappers customerMappers) {
		super();
		this.customerRepository = customerRepository;
		this.customerMappers = customerMappers;
	}

	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		Customer customer= customerMappers.fromCustomerRequestDTO(customerRequestDTO);
		Customer saveCustomer= customerRepository.save(customer);
		
		CustomerResponseDTO customerResponseDTO=customerMappers.fromCustomer(saveCustomer);
		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO getCustomer(String customerId) {
		   Customer customer=customerRepository.findById(customerId).get();
		return customerMappers.fromCustomer(customer);
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        if (customerRequestDTO.getId() == null || customerRequestDTO.getId().isEmpty()) {
            throw new IllegalArgumentException("Customer ID must be provided for update.");
        }

        // Vérifiez si le client existe
        Customer existingCustomer = customerRepository.findById(customerRequestDTO.getId())
            .orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + customerRequestDTO.getId()));

        // Mappez les données de DTO à l'entité
        Customer customerToUpdate = customerMappers.fromCustomerRequestDTO(customerRequestDTO);
        customerToUpdate.setId(existingCustomer.getId()); // Conserver l'ID existant

        // Sauvegardez le client mis à jour
        Customer updatedCustomer = customerRepository.save(customerToUpdate);
        return customerMappers.fromCustomer(updatedCustomer);
    }


	@Override
	public List<CustomerResponseDTO> listCustomer() {
		List<Customer> customers=customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOs=customers
				.stream()
				.map(cust->customerMappers
						.fromCustomer(cust))
				.collect(Collectors.toList());
		return customerResponseDTOs;
	}

	@Override
	public List<CustomerResponseDTO> searchCustomer(String keyword) {
		 List<Customer> customers= customerRepository.findByNameContains(keyword);
		 List<CustomerResponseDTO> customerResponseDTOs=customers
				 .stream()
				 .map(cut->customerMappers
						 .fromCustomer(cut)).collect(Collectors.toList());
		 
		return customerResponseDTOs;
	}

}

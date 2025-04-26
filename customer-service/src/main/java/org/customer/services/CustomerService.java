package org.customer.services;

import java.util.List;

import org.customer.dto.CustomerRequestDTO;
import org.customer.dto.CustomerResponseDTO;
public interface CustomerService {
	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO getCustomer(String customerId);
	CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
	List<CustomerResponseDTO> listCustomer();
	List<CustomerResponseDTO> searchCustomer(String keyword);
    
}

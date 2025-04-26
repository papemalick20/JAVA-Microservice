package org.openlab.services;

import org.openlab.dto.CustomerRequestDTO;
import org.openlab.dto.CustomerResponseDTO;

import java.util.List;



public interface CustomerService {
 CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
 CustomerResponseDTO getCustomer(String id);
 CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
 List<CustomerResponseDTO> listCustomer();

}

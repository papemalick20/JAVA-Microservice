package org.openlab.mappers;

import org.mapstruct.Mapper;
import org.openlab.dto.CustomerRequestDTO;
import org.openlab.dto.CustomerResponseDTO;
import org.openlab.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	public CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
	public Customer customerRequestDTOtocustomer(CustomerRequestDTO customerRequestDTO);

}

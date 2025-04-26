package org.customer.mappers;

import org.customer.dto.CustomerRequestDTO;
import org.customer.dto.CustomerResponseDTO;
import org.customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMappers {
 public CustomerResponseDTO fromCustomer(Customer customer);
 public Customer fromCustomerRequestDTO(CustomerRequestDTO customerRequestDTO);
}

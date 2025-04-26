package org.order.mappers;

import org.mapstruct.Mapper;
import org.order.dto.OrderRequestDTO;
import org.order.dto.OrderResponseDTO;
//import org.order.entities.Order;
import org.order.entities.OrderCustoner;

@Mapper(componentModel = "spring")
public interface OrderMappers {
	OrderCustoner fromOrderCustonerDTO(OrderRequestDTO orderRequestDTO);
	OrderResponseDTO fromOrder(OrderCustoner order);
	

}

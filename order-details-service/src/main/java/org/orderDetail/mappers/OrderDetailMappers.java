package org.orderDetail.mappers;

import org.mapstruct.Mapper;
import org.orderDetail.dto.OrderDetailRequestDTO;
import org.orderDetail.dto.OrderDetailResponseDTO;
import org.orderDetail.entities.OrderDetail;
@Mapper(componentModel = "spring")
public interface OrderDetailMappers {
	OrderDetail fromOrderDetailRequestDTO(OrderDetailRequestDTO orderDetailRequestDTO);
	OrderDetailResponseDTO fromOrdertail(OrderDetail orderDetail);

}

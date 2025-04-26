package org.orderDetail.services;

import java.util.List;

import org.orderDetail.dto.OrderDetailRequestDTO;
import org.orderDetail.dto.OrderDetailResponseDTO;
//import org.orderDetail.entities.Product;

public interface OrderDetailService {
	OrderDetailResponseDTO save(OrderDetailRequestDTO orderDetailRequestDTO) throws Exception;
	OrderDetailResponseDTO getDetail(String detailId);
	List<OrderDetailResponseDTO> alldetails();
	List<OrderDetailResponseDTO> orderDetailByProductId(String productId);
	List<OrderDetailResponseDTO> allDetailByOrderId(String orderId);

	
}

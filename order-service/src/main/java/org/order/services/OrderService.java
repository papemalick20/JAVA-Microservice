package org.order.services;

import java.util.List;

import org.order.dto.OrderRequestDTO;
import org.order.dto.OrderResponseDTO;
import org.order.enums.OrderStatut;

public interface OrderService {

    OrderResponseDTO save(OrderRequestDTO orderRequestDTO) throws Exception;

    OrderResponseDTO getOrder(String orderId);

    List<OrderResponseDTO> ordersByCustomerId(String customerId);

    List<OrderResponseDTO> allOrders();

    List<OrderResponseDTO> orderBygetProduct(String productId);

    
    OrderResponseDTO updateOrder(String orderId, OrderRequestDTO orderRequestDTO) throws Exception;
      
    OrderResponseDTO updateOrderStatut(String orderId, OrderRequestDTO newStatut) throws Exception;
}

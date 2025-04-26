package org.orderDetail.repository;

import java.util.List;

import org.orderDetail.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{
	List<OrderDetail> findByProductId(String productId);
	List<OrderDetail> findByOrderId(String orderId);

}

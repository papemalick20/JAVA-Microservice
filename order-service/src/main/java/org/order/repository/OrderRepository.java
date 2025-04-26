package org.order.repository;

import java.util.List;

//import org.order.entities.Order;
import org.order.entities.OrderCustoner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderCustoner, String>{
	List<OrderCustoner> findByCustomerId(String customerId);
	List<OrderCustoner> findByProductId(String productId);
   
}

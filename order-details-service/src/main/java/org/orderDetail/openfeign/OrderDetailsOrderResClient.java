package org.orderDetail.openfeign;

import java.util.List;

import org.orderDetail.entities.OrderCustoner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ORDER-SERVICE")
public interface OrderDetailsOrderResClient {
	
	@GetMapping(path="/api/orders/{id}")
	OrderCustoner getOrderCustoner(@PathVariable(name="id") String id);
	
	@GetMapping(path="/api/orders")
	List<OrderCustoner> allCustoners();

}

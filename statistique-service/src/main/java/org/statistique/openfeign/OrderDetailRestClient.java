package org.statistique.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.statistique.entities.OrderDetail;

@FeignClient(name="ORDER-DETAIL-SERVICE", url ="http://localhost:8084")
public interface OrderDetailRestClient {
	
	@GetMapping(path="/api/orderdetails")
	List<OrderDetail> getAlldetails();
	
	@GetMapping(path="/orders/{orderId}")
	List<OrderDetail> detOrderDetails(@PathVariable String orderId);

}

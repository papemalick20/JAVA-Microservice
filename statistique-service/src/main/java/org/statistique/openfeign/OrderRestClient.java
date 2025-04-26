package org.statistique.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.statistique.entities.OrderCustoner;

@FeignClient(name="ORDER-SERVICE", url ="http://localhost:8083")
public interface OrderRestClient {
	@GetMapping(path="/api/orders/{id}")
	OrderCustoner getCustoner(@PathVariable String id);
	
	@GetMapping(path="/api/orders")
	List<OrderCustoner> getAllorderCustoners();

}

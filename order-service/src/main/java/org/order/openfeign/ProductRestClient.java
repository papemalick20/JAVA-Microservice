package org.order.openfeign;

import java.util.List;

import org.order.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductRestClient {
	
	@GetMapping(path="/api/products/{id}")
	Product getProduct(@PathVariable(name="id") String id);
	
	@GetMapping(path="/api/products")
	List<Product> allDetails();

}

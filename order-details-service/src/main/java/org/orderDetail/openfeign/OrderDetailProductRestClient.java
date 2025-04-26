package org.orderDetail.openfeign;

import java.util.List;


import org.orderDetail.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="PRODUCT-SERVICE")
public interface OrderDetailProductRestClient {
	
	@GetMapping(path="/api/products/{id}")
	Product getProduct(@PathVariable(name="id") String id);
	
	@GetMapping(path="/api/products")
	List<Product> allDetails();
	
	/*
	 * // Méthode pour mettre à jour un produit
	 * 
	 * @PutMapping(path="/api/products/{id}") Product
	 * updateProduct(@PathVariable(name="id") String id, @RequestBody Product
	 * product);
	 */
	

}

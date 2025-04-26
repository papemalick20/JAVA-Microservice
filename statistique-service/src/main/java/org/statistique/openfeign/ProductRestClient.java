package org.statistique.openfeign;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.statistique.entities.Product;

@FeignClient(name="PRODUCT-SERVICE", url ="http://localhost:8082")
public interface ProductRestClient {
	
	@GetMapping(path="/api/products/{id}")
	Product getProduct(@PathVariable(name="id") String id);
	
	@GetMapping(path="/api/products")
	List<Product> allDetails();

}

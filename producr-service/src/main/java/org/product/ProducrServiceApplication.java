package org.product;

import org.product.dto.ProductRequestDTO;
//import org.product.dto.ProductResponseDTO;
import org.product.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducrServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductService productService) {
		
		return args->{
			productService.save(new ProductRequestDTO("p01", "machine", "vraie qualite", 2500000, 34));
			productService.save(new ProductRequestDTO("p02", "portable", "samsung", 90000, 30));
			productService.save(new ProductRequestDTO("p03", "television", "Philip", 3500000, 25));
		};
		
	}

}

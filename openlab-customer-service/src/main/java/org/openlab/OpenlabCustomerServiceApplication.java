package org.openlab;

import org.openlab.dto.CustomerRequestDTO;
import org.openlab.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenlabCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenlabCustomerServiceApplication.class, args);
	}
	@Bean
	 CommandLineRunner start(CustomerService customerService) {
		 return args->{
			 customerService.save(new CustomerRequestDTO("c01","thioune","emoro@gmail.com"));
			 customerService.save(new CustomerRequestDTO("c02","coly","coly@gmail.com"));
			 customerService.save(new CustomerRequestDTO("c03","sall","sall@gmail.com"));
		 };
	 }

}

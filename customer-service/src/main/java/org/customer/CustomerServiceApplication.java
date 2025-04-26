package org.customer;

import org.customer.dto.CustomerRequestDTO;
import org.customer.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerService customerService) {
		return args->{
			customerService.save(new CustomerRequestDTO("c01", "thioune malick", "thioun@gmail.com", "772394201", "malika"));
			customerService.save(new CustomerRequestDTO("c02", "coly seynabou", "coly@gmail.com", "773528564", "manguiline"));
			customerService.save(new CustomerRequestDTO("c03", "sane yaya", "sane@gmail.com", "775277877", "hlm"));
		};
	}

}

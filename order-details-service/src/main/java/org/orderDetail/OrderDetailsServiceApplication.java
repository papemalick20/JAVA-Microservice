package org.orderDetail;

import org.orderDetail.dto.OrderDetailRequestDTO;
import org.orderDetail.services.OrderDetailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class OrderDetailsServiceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(OrderDetailsServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(OrderDetailService orderDetailService) {
		return args->{
			
			orderDetailService.save(new OrderDetailRequestDTO("p01","ord1"));
			orderDetailService.save(new OrderDetailRequestDTO("p02","ord2"));
			orderDetailService.save(new OrderDetailRequestDTO("p03","ord3"));
		};
	}
}

package org.order;

//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.Date;

import org.order.dto.OrderRequestDTO;
import org.order.enums.OrderStatut;
import org.order.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	@Bean
	 CommandLineRunner start(OrderService orderService) {
		return args->{
			//LocalDate orderDate= LocalDate.now()
			orderService.save(new OrderRequestDTO( "ord1","c01", OrderStatut.PENDING ,23,"p01"));
			orderService.save(new OrderRequestDTO("ord2","c02", OrderStatut.PENDING,15,"p02"));
			orderService.save(new OrderRequestDTO("ord3","c03", OrderStatut.CANCELLED, 3,"p03"));
		};
	}

}

package org.statistique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class StatistiqueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatistiqueServiceApplication.class, args);
	}

}

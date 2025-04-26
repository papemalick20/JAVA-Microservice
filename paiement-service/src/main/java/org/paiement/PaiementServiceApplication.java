package org.paiement;

import org.paiement.dto.PaymentRequestDTO;
import org.paiement.enums.PaiementMethode;
import org.paiement.enums.PaiementStatus;
import org.paiement.services.PaymentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class PaiementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaiementServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(PaymentService paymentService) {
		
		return args->{
			paymentService.save(new PaymentRequestDTO("pm1","ord1",6780.45,PaiementMethode.WAVE, PaiementStatus.PENDING));
			paymentService.save(new PaymentRequestDTO("pm2","ord2",450.15,PaiementMethode.ORANGEMONEY, PaiementStatus.CANCELLED));
			paymentService.save(new PaymentRequestDTO("pm3","ord3",450.15,PaiementMethode.ORANGEMONEY, PaiementStatus.PENDING));
			
		};
		
	}

}

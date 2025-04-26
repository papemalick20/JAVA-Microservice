package org.statistique.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.statistique.entities.Payment;

@FeignClient(name="PAIEMENT-SERVICE", url ="http://localhost:8085")
public interface PaymentRestClient {
	@GetMapping(path="/api/payments/{id}")
	Payment getPayment(@PathVariable String id);
	
	@GetMapping(path="/api/payments")
	List<Payment> getAllpayments();

}

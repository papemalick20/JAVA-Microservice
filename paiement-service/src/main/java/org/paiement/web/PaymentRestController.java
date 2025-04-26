package org.paiement.web;

import java.util.List;
import java.util.UUID;

import org.paiement.dto.PaymentRequestDTO;
import org.paiement.dto.PaymentResponseDTO;
import org.paiement.services.PaymentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class PaymentRestController {
	private final PaymentService paymentService;

	public PaymentRestController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@PostMapping(path="/payments")
	public PaymentResponseDTO save(@RequestBody PaymentRequestDTO paymentRequestDTO) throws Exception {
		paymentRequestDTO.setId(UUID.randomUUID().toString());
		return paymentService.save(paymentRequestDTO);
		
	}
	@GetMapping(path="/payments/{id}")
	public PaymentResponseDTO etPaymentResponseDTO(@PathVariable(name="id") String id) {
		return paymentService.getPayment(id);
		
	}
	@GetMapping(path="/payments")
	List<PaymentResponseDTO> allPaymentResponseDTOs(){
		return paymentService.allPayments();
		
	}
	
	@GetMapping(path="/orders/{orderId}")
	public List<PaymentResponseDTO> getallPaymentByOrder(@PathVariable(name="orderId") String orderId){
		return paymentService.getByOrderCustoner(orderId);
		
	}
	
	@PostMapping(path="/payemts/statut")
	public PaymentResponseDTO savePaymentandOrderStatu(@RequestBody PaymentRequestDTO paymentRequestDTO) throws Exception {
		return paymentService.save(paymentRequestDTO);
		
		
	}
}

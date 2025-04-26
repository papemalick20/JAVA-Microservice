package org.paiement.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.paiement.dto.PaymentRequestDTO;
import org.paiement.dto.PaymentResponseDTO;
import org.paiement.entities.OrderCustoner;
import org.paiement.entities.Payment;
import org.paiement.enums.PaiementStatus;
import org.paiement.mappers.PaymentMappers;
import org.paiement.openfeign.PaymentRestClient;
import org.paiement.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class PaymentServiceImpl<OrderStatut> implements PaymentService{

	private PaymentRepository paymentRepository;
	private PaymentRestClient paymentRestClient;
	private PaymentMappers paymentMappers;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentRestClient paymentRestClient,
			PaymentMappers paymentMappers) {
		super();
		this.paymentRepository = paymentRepository;
		this.paymentRestClient = paymentRestClient;
		this.paymentMappers = paymentMappers;
	}

	@Override
	public PaymentResponseDTO save(PaymentRequestDTO paymentRequestDTO) throws Exception {
	    
	    Payment payment = paymentMappers.fromPaymentRequestDTO(paymentRequestDTO);

	    OrderCustoner orderCustoner = paymentRestClient.getOrderCustoner(payment.getOrderId());
	    
	    if (orderCustoner == null) throw new Exception("Order not found with id: " + payment.getOrderId());
            payment.setMethode(payment.getMethode());
            payment.setAmount(payment.getAmount());
            
	    // Enregistrer le paiement
	    payment.setPaiementDate(new Date());
	    Payment savedPayment = paymentRepository.save(payment);
          savedPayment.setOrderCustoner(orderCustoner);
          
	    // Mettre à jour le statut de la commande après l'enregistrement du paiement
	    try {
	        // Récupérer le statut du paiement depuis le DTO
	        PaiementStatus paymentStatus = paymentRequestDTO.getStatut();
	       
	        // Mettre à jour l'objet OrderCustoner avec le nouveau statut
	        orderCustoner.setStatut(paymentStatus);

	        // Appeler le client REST pour mettre à jour la commande avec le nouvel objet OrderCustoner
	        paymentRestClient.updateOrderStatut(payment.getOrderId(), orderCustoner);

	    } catch (Exception e) {
	        // Log the error and continue to ensure the payment is still saved
	        System.err.println("Failed to update order status: " + e.getMessage());
	    }

	    // Retourner le paiement enregistré
	    return paymentMappers.fromPayment(savedPayment);
	}




	@Override
	public PaymentResponseDTO getPayment(String paymentId) {
		Payment payment=paymentRepository.findById(paymentId).get();
		OrderCustoner orderCustoner=paymentRestClient.getOrderCustoner(payment.getOrderId());
		payment.setOrderCustoner(orderCustoner);
		return paymentMappers.fromPayment(payment);
	}

	@Override
	public List<PaymentResponseDTO> getByOrderCustoner(String orderId) {
		List<Payment> payments=paymentRepository.findByOrderId(orderId);
		for(Payment pmt: payments) {
			OrderCustoner orderCustoner=paymentRestClient.getOrderCustoner(pmt.getOrderId());
			pmt.setOrderCustoner(orderCustoner);
		}
		return payments
				.stream()
				.map(pyt->paymentMappers
				.fromPayment(pyt))
				.collect(Collectors.toList());
	}

	@Override
	public List<PaymentResponseDTO> allPayments() {
		List<Payment> payments=paymentRepository.findAll();
		for(Payment pmt:payments) {
			OrderCustoner orderCustoner=paymentRestClient.getOrderCustoner(pmt.getOrderId());
			pmt.setOrderCustoner(orderCustoner);
		}
		return payments
				.stream()
				.map(pyt->paymentMappers
				.fromPayment(pyt))
				.collect(Collectors.toList());
	}

	
}

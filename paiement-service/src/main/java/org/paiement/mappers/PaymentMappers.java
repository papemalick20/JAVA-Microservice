package org.paiement.mappers;

import org.mapstruct.Mapper;
import org.paiement.dto.PaymentRequestDTO;
import org.paiement.dto.PaymentResponseDTO;
import org.paiement.entities.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMappers {
	
Payment fromPaymentRequestDTO(PaymentRequestDTO paymentRequestDTO);
PaymentResponseDTO fromPayment(Payment payment);
	
}

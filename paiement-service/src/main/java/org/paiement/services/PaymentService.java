package org.paiement.services;

import java.util.List;

import org.paiement.dto.PaymentRequestDTO;
import org.paiement.dto.PaymentResponseDTO;

public interface PaymentService {
PaymentResponseDTO save(PaymentRequestDTO paymentRequestDTO) throws Exception;
PaymentResponseDTO getPayment(String paymentId);
List<PaymentResponseDTO> getByOrderCustoner(String orderId);
List<PaymentResponseDTO> allPayments();
 
}

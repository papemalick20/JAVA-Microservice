package org.paiement.repository;

import java.util.List;

import org.paiement.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
	List<Payment> findByOrderId(String orderId);

}

package org.paiement.dto;

import org.paiement.enums.PaiementMethode;
import org.paiement.enums.PaiementStatus;

public class PaymentRequestDTO {
	private String id;
	private String orderId;
	
	private Double amount;
	
	private PaiementMethode methode;
	
	private PaiementStatus statut;

	public PaymentRequestDTO(String id, String orderId, Double amount, PaiementMethode methode, PaiementStatus statut) {
		super();
		this.id=id;
		this.orderId = orderId;
		this.amount = amount;
		this.methode = methode;
		this.statut = statut;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaiementMethode getMethode() {
		return methode;
	}

	public void setMethode(PaiementMethode methode) {
		this.methode = methode;
	}

	public PaiementStatus getStatut() {
		return statut;
	}

	public void setStatut(PaiementStatus statut) {
		this.statut = statut;
	}
	

	

}

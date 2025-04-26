package org.paiement.dto;

import java.util.Date;

import org.paiement.entities.OrderCustoner;
import org.paiement.enums.PaiementMethode;
import org.paiement.enums.PaiementStatus;

public class PaymentResponseDTO {

	private String id;
	private Date paiementDate;
	private Double amount;
	private PaiementMethode methode;
	private PaiementStatus statut;
	private OrderCustoner orderCustoner;
	public PaymentResponseDTO(String id, Date paiementDate,Double amount ,PaiementMethode methode,PaiementStatus statut,OrderCustoner orderCustoner) {
		super();
		this.id = id;
		this.paiementDate = paiementDate;
		this.amount = amount;
		this.methode = methode;
		this.statut = statut;
		this.orderCustoner=orderCustoner;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getPaiementDate() {
		return paiementDate;
	}
	public void setPaiementDate(Date paiementDate) {
		this.paiementDate = paiementDate;
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
	
	public  OrderCustoner getOrderCustoner() {
		return orderCustoner;
	}
	 public void setOrderCustoner(OrderCustoner orderCustoner) {
		 this.orderCustoner=orderCustoner;
	 }
	
}

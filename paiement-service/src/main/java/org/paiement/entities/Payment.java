package org.paiement.entities;

import java.util.Date;

import org.paiement.enums.PaiementMethode;
import org.paiement.enums.PaiementStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Payment {
	
	@Id
	private String id;
	private String orderId;
	private Date paiementDate;
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private PaiementMethode methode;
	
	@Enumerated(EnumType.STRING)
	private PaiementStatus statut;
	
	@Transient
	private OrderCustoner orderCustoner;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(String id, String orderId, Date paiementDate, Double amount, PaiementMethode methode,
			PaiementStatus statut, OrderCustoner orderCustoner) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.paiementDate = paiementDate;
		this.amount = amount;
		this.methode = methode;
		this.statut = statut;
		this.orderCustoner = orderCustoner;
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

	public OrderCustoner getOrderCustoner() {
		return orderCustoner;
	}

	public void setOrderCustoner(OrderCustoner orderCustoner) {
		this.orderCustoner = orderCustoner;
	}
	
	

}

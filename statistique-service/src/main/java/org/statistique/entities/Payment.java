package org.statistique.entities;

import org.statistique.enums.PaiementStatut;

public class Payment {
	
	private String id;
	
	private Double amount;
	
	private PaiementStatut statut;

	public Payment(String id, Double amount, PaiementStatut statut) {
		super();
		this.id = id;
		this.amount = amount;
		this.statut = statut;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaiementStatut getStatut() {
		return statut;
	}

	public void setStatut(PaiementStatut statut) {
		this.statut = statut;
	}

	
	

}

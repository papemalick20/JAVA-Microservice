package org.orderDetail.entities;

import java.util.Date;

public class OrderCustoner {
	
	private String id;
	private Date orderDate;
	private String statut;
	private Integer quantityOrder;
	public OrderCustoner(String id, Date orderDate, String statut, Integer quantityOrder) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.statut = statut;
		this.quantityOrder=quantityOrder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Integer getQuantityOrder() {
		return quantityOrder;
	}

	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

	
	

}

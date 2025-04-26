package org.order.dto;

import org.order.enums.OrderStatut;

//import org.order.enums.OrderStatut;

//import java.time.LocalDate;
//import java.util.Date;
//import java.util.Date;

public class OrderRequestDTO {
	private String id;
	
	private String customerId;
	private OrderStatut statut;
	private String productId;
	private Integer quantityOrder;
	
	public OrderRequestDTO(String id, String customerId, OrderStatut statut, Integer quantityOrder, String productId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.statut = statut;
		this.productId = productId;
		this.quantityOrder = quantityOrder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public OrderStatut getStatut() {
		return statut;
	}

	public void setStatut(OrderStatut statut) {
		this.statut = statut;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getQuantityOrder() {
		return quantityOrder;
	}

	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}
	
	
	
	
	
	
	
	
  
	
}

package org.statistique.entities;

import org.statistique.enums.OrderStatut;



public class OrderCustoner {
	
  private String id;
	
  private String customerId;
	
  private String productId;
	
  private Integer quantityOrder;
  
  //@Enumerated(EnumType.STRING)
  private OrderStatut statut;

public OrderCustoner(String id, String customerId, String productId, Integer quantityOrder, OrderStatut statut) {
	super();
	this.id = id;
	this.customerId = customerId;
	this.productId = productId;
	this.quantityOrder = quantityOrder;
	this.statut = statut;
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

public OrderStatut getStatut() {
	return statut;
}

public void setStatut(OrderStatut statut) {
	this.statut = statut;
}


}

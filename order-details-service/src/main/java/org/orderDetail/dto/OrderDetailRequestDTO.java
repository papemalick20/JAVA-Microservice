package org.orderDetail.dto;



public class OrderDetailRequestDTO {
	//private String id;
	//private Integer quantity;
	private String productId;
	private String orderId;
	public OrderDetailRequestDTO(String productId, String orderId) {
		super();
		//this.quantity = quantity;
		this.orderId = orderId;
		this.productId = productId;
	}

	/*
	 * public Integer getQuantity() { return quantity; }
	 * 
	 * public void setQuantity(Integer quantity) { this.quantity = quantity; }
	 */

	
	  public String getOrderId() { return orderId; }
	 
	  public void setOrderId(String orderId) { this.orderId = orderId; }
	 

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	
}

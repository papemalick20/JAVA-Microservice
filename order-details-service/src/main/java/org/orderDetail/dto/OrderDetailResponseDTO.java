package org.orderDetail.dto;

import org.orderDetail.entities.OrderCustoner;
//import org.orderDetail.entities.OrderCustoner;
import org.orderDetail.entities.Product;



public class OrderDetailResponseDTO {
	
	private String id;
	private Integer quantityOrder;
	private Double price;
	private String productId;
	private String orderId;
	private Product product;
	private OrderCustoner orderCustoner;
	public OrderDetailResponseDTO(String id, Integer quantityOrder, Double price, String productId, String orderId,
			Product product, OrderCustoner orderCustoner) {
		super();
		this.id = id;
		this.quantityOrder = quantityOrder;
		this.price = price;
		this.productId = productId;
		this.orderId = orderId;
		this.product = product;
		this.orderCustoner = orderCustoner;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantityOrder() {
		return quantityOrder;
	}
	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderCustoner getOrderCustoner() {
		return orderCustoner;
	}
	public void setOrderCustoner(OrderCustoner orderCustoner) {
		this.orderCustoner = orderCustoner;
	}
	
	
	
	
	}

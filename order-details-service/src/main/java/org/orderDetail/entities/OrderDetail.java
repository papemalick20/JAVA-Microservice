package org.orderDetail.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
@Entity
public class OrderDetail {
	@Id
	private String id;
	private Integer quantityOrder;
	private Double price;
	private String orderId;
	private String productId;
	
	
	/*
	 * @Transient private OrderCustoner ordercustomer;
	 */
    
	@Transient
	private Product product;
	
	@Transient
	private OrderCustoner orderCustoner;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(String id, Integer quantityOrder, Double price, String orderId, String productId, Product product,
			OrderCustoner orderCustoner) {
		super();
		this.id = id;
		this.quantityOrder = quantityOrder;
		this.price = price;
		this.orderId = orderId;
		this.productId = productId;
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

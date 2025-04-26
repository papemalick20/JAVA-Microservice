package org.order.dto;

import java.time.LocalDate;
//import java.util.Date;

import org.order.entities.Customer;
import org.order.entities.Product;
import org.order.enums.OrderStatut;

public class OrderResponseDTO {
	
	
	private String id;
	private String productId;
	private String customerId;
	private LocalDate orderDate;
	private OrderStatut statut;
	private Integer quantityOrder;
	private Integer newStock;
	private Product product;
	private Customer customer;
	
	public OrderResponseDTO(String id,
			LocalDate orderDate, 
			OrderStatut statut, 
			Product product,Customer customer, 
			Integer newStock, String productId, String customerId, Integer quantityOrder) {
		super();
		this.id = id;
		this.productId=productId;
		this.customerId=customerId;
		this.orderDate = orderDate;
		this.statut = statut;
		this.customer = customer;
		this.product=product;
		this.newStock=newStock;
		this.quantityOrder=quantityOrder;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatut getStatut() {
		return statut;
	}
	public void setStatut(OrderStatut statut) {
		this.statut = statut;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getNewStock() {
		return newStock;
	}
	public void setNewStock(Integer newStock) {
		this.newStock = newStock;
	}
	public Integer getQuantityOrder() {
		return quantityOrder;
	}
	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}
	
	

}

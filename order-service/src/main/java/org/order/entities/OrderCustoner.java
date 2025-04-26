package org.order.entities;

//import java.time.LocalDate;
//import java.util.Date;
import java.util.Date;

import org.order.enums.OrderStatut;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class OrderCustoner {
	@Id
	private String id;
	private Date orderDate;
	private Integer quantityOrder;
	private Integer newStock;
	
	
	private String productId;
	
	@Transient
	private Product product;
	 
	 
	@Enumerated(EnumType.STRING)
	private OrderStatut statut;
	
	private String customerId;
	@Transient
	private Customer customer;
	
	public OrderCustoner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderCustoner(String id, Date orderDate, OrderStatut statut, String customerId, Customer customer, Product product, Integer quantityOrder, Integer newStock) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.statut = statut;
		this.customerId = customerId;
		this.customer = customer;
		this.product=product;
		this.quantityOrder=quantityOrder;
		this.newStock=newStock;
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

	public OrderStatut getStatut() {
		return statut;
	}

	public void setStatut(OrderStatut statut) {
		this.statut = statut;
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
		 this.productId=productId;
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

	public Integer getQuantityOrder() {
		return quantityOrder;
	}

	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

	public Integer getNewStock() {
		return newStock;
	}

	public void setNewStock(Integer newStock) {
		this.newStock = newStock;
	}
	
	
	

}

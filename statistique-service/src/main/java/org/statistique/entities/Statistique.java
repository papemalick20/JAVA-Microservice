package org.statistique.entities;

import java.util.Date;
import java.util.Map;


import lombok.Data;

//@Entity
@Data
public class Statistique {
	
	private String id;
	
	private Integer totalVente;
	
	private Map<String, Integer> produitsLesPlusVendus; // ID du produit et quantité vendue
	
	 private Map<String, Integer> meilleursClients; // ID du client et montant total des achats
	 
	 private Date dateCalcul; 
	 
	 private String productId;
	 
	 private String customerId;
	 
	 private String orderId;
	 
	 private String detailId;
	 
	 private String paymentId;
	 
    
    private Product product;  

    
    private OrderCustoner orderCustoner;  

    
    private Customer customer;  
    
   
    private OrderDetail orderDetail;
    
    
    private Payment payment;

	public Statistique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Statistique(String id, Integer totalVente, Map<String, Integer> produitsLesPlusVendus,
			Map<String, Integer> meilleursClients, Date dateCalcul, String productId, String customerId, String orderId,
			String detailId, String paymentId, Product product, OrderCustoner orderCustoner, Customer customer,
			OrderDetail orderDetail, Payment payment) {
		super();
		this.id = id;
		this.totalVente = totalVente;
		this.produitsLesPlusVendus = produitsLesPlusVendus;
		this.meilleursClients = meilleursClients;
		this.dateCalcul = dateCalcul;
		this.productId = productId;
		this.customerId = customerId;
		this.orderId = orderId;
		this.detailId = detailId;
		this.paymentId = paymentId;
		this.product = product;
		this.orderCustoner = orderCustoner;
		this.customer = customer;
		this.orderDetail = orderDetail;
		this.payment = payment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTotalVente() {
		return totalVente;
	}

	public void setTotalVente(Integer totalVente) {
		this.totalVente = totalVente;
	}

	public Map<String, Integer> getProduitsLesPlusVendus() {
		return produitsLesPlusVendus;
	}

	public void setProduitsLesPlusVendus(Map<String, Integer> produitsLesPlusVendus) {
		this.produitsLesPlusVendus = produitsLesPlusVendus;
	}

	public Map<String, Integer> getMeilleursClients() {
		return meilleursClients;
	}

	public void setMeilleursClients(Map<String, Integer> meilleursClients) {
		this.meilleursClients = meilleursClients;
	}

	public Date getDateCalcul() {
		return dateCalcul;
	}

	public void setDateCalcul(Date dateCalcul) {
		this.dateCalcul = dateCalcul;
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
    
    

	
	
    


}

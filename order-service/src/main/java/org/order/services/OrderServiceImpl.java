package org.order.services;


import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;

import org.order.dto.OrderRequestDTO;
import org.order.dto.OrderResponseDTO;
import org.order.entities.Customer;
import org.order.entities.OrderCustoner;
import org.order.entities.Product;
import org.order.mappers.OrderMappers;
import org.order.openfeign.CustomerRestClient;
import org.order.openfeign.ProductRestClient;
import org.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl  implements OrderService{
	private OrderRepository orderRepository;
	private OrderMappers orderMappers;
	private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

	public OrderServiceImpl(OrderRepository orderRepository, OrderMappers orderMappers,
			CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
		super();
		this.orderRepository = orderRepository;
		this.orderMappers = orderMappers;
		this.customerRestClient = customerRestClient;
		this.productRestClient=productRestClient;
	}

	@Override
	public OrderResponseDTO save(OrderRequestDTO orderRequestDTO) throws Exception {
		
	    try {
	        OrderCustoner order = orderMappers.fromOrderCustonerDTO(orderRequestDTO);
	        Product product=productRestClient.getProduct(order.getProductId());
	        Customer customer = customerRestClient.getCustomer(order.getCustomerId());
	        
	        if (customer == null || product==null) throw new Exception("Customer or product not found");
	         
	        if(order.getQuantityOrder()> product.getStock()) {
	        	throw new Exception("Insufficiant stock for product");
	        }
	        order.setOrderDate(new Date());
	        order.setCustomerId(customer.getId());
	        order.setProductId(product.getId());
	        order.setNewStock(product.getStock()-order.getQuantityOrder());
	        

	        OrderCustoner savedOrder = orderRepository.save(order);
	        savedOrder.setProduct(product);
	        savedOrder.setCustomer(customer);
	       
	        return orderMappers.fromOrder(savedOrder);
	    } catch (Exception e) {
	        e.printStackTrace();  
	        throw e;
	    }
	}


	@Override
	public OrderResponseDTO getOrder(String orderId) {
		OrderCustoner order=orderRepository.findById(orderId).get();
		Customer customer=customerRestClient.getCustomer(order.getCustomerId());
		Product product=productRestClient.getProduct(order.getProductId());
		order.setCustomer(customer);
		order.setProduct(product);
		return orderMappers.fromOrder(order);
	}

	@Override
	public List<OrderResponseDTO> ordersByCustomerId(String customerId) {
		List<OrderCustoner> orders=orderRepository.findByCustomerId(customerId);
		for(OrderCustoner ord: orders) {
			Customer customer=customerRestClient.getCustomer(ord.getCustomerId());
			ord.setCustomer(customer);
		}
		return orders
				.stream()
				.map(od->orderMappers
				.fromOrder(od))
				.collect(Collectors.toList());
				
		
		
	}
	 public List<OrderResponseDTO> allOrders(){
		 List<OrderCustoner> orders=orderRepository.findAll();
		 for(OrderCustoner ord: orders) {
			 Customer customer=customerRestClient.getCustomer(ord.getCustomerId());
			 Product product=productRestClient.getProduct(ord.getProductId());
			 ord.setCustomer(customer);
			 ord.setProduct(product);
		 }
		 return orders
				 .stream()
				 .map(od->orderMappers
				 .fromOrder(od))
				 .collect(Collectors.toList());
	 }

	@Override
	public List<OrderResponseDTO> orderBygetProduct(String productId) {
		
		List<OrderCustoner> orders=orderRepository.findByProductId(productId);
		for(OrderCustoner ord: orders) {
			Product product=productRestClient.getProduct(ord.getProductId());
			ord.setProduct(product);
		}
		return orders
				.stream()
				.map(od->orderMappers
				.fromOrder(od))
				.collect(Collectors.toList());
	}

	/*
	 * @Override public List<OrderResponseDTO> orderByProduct(String productId) { //
	 * TODO Auto-generated method stub return null; }
	 */

	@Override
	public OrderResponseDTO updateOrder(String orderId, OrderRequestDTO orderRequestDTO) throws Exception {
	    // Vérifier si la commande existe
	    OrderCustoner existingOrder = orderRepository.findById(orderId)
	        .orElseThrow(() -> new Exception("Order not found with id: " + orderId));
	    Product product = productRestClient.getProduct(orderRequestDTO.getProductId());
	    Customer customer = customerRestClient.getCustomer(orderRequestDTO.getCustomerId());

	    if (customer == null || product == null) {
	        throw new Exception("Customer or product not found");
	    }

	    if (orderRequestDTO.getQuantityOrder() > product.getStock()) {
	        throw new Exception("Insufficient stock for the order");
	    }

	    // Mettre à jour les champs de la commande existante avec les nouvelles valeurs
	    existingOrder.setProductId(product.getId());
	    existingOrder.setCustomerId(customer.getId());
	    existingOrder.setQuantityOrder(orderRequestDTO.getQuantityOrder());
	    existingOrder.setOrderDate(new Date());  	  
	    existingOrder.setNewStock(product.getStock() - orderRequestDTO.getQuantityOrder());

	    // Mettre à jour le statut si nécessaire
	    //existingOrder.setStatut(OrderStatut.SUCCED); 

	    OrderCustoner updatedOrder = orderRepository.save(existingOrder);
	    
	    updatedOrder.setProduct(product);
	    updatedOrder.setCustomer(customer);

	   
	    return orderMappers.fromOrder(updatedOrder);
	}

	
	   
	    // Méthode pour mettre à jour uniquement le statut d'une commande
	
	public OrderResponseDTO updateOrderStatut(String orderId, OrderRequestDTO newStatut) throws Exception {
	    
	    OrderCustoner orderCustoner = orderRepository.findById(orderId)
	      .orElseThrow(() -> new Exception("Order not found with id: " + orderId));
	    
          Customer customer=customerRestClient.getCustomer(orderCustoner.getCustomerId());
          Product product=productRestClient.getProduct(orderCustoner.getProductId());
          
	    // Mettre à jour le statut de la commande
	    orderCustoner.setStatut(newStatut.getStatut());

	    OrderCustoner savedOrderCustoner = orderRepository.save(orderCustoner);
         savedOrderCustoner.setCustomer(customer);
         savedOrderCustoner.setProduct(product);
	    
	    return orderMappers.fromOrder(savedOrderCustoner);
	}

	

	
	

}


	        
		
       
				
		
	



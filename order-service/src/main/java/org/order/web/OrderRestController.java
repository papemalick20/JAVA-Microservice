package org.order.web;

import java.util.List;
import java.util.UUID;

import org.order.dto.OrderRequestDTO;
import org.order.dto.OrderResponseDTO;

import org.order.services.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class OrderRestController {

    private final OrderService orderService;
    
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path="/orders")
    public OrderResponseDTO save(@RequestBody OrderRequestDTO orderRequestDTO) throws Exception {
    	orderRequestDTO.setId(UUID.randomUUID().toString());
        return orderService.save(orderRequestDTO);
    }

    @GetMapping(path="/orders/{id}")
    public OrderResponseDTO getOrder(@PathVariable(name="id") String orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping(path="/customers/{customerId}")
    public List<OrderResponseDTO> getAllOrdersByCustomer(@PathVariable String customerId) {
        return orderService.ordersByCustomerId(customerId);
    }
    @GetMapping("/products/productId")
    public List<OrderResponseDTO> getAllOrderByProduct(@PathVariable String productId){
		return orderService.orderBygetProduct(productId);
    	
    }

    @GetMapping(path="/orders")
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.allOrders();
    }
     @PutMapping(path="/orders/{orderId}")
    public OrderResponseDTO updateorder(@PathVariable(name="orderId") String orderId, @RequestBody OrderRequestDTO orderRequestDTO) throws Exception {
		return orderService.updateOrder(orderId, orderRequestDTO);
    	
    }
     
     @PutMapping(path="/orders/{orderId}/statut") 
     public OrderResponseDTO updateOrderStatutCustomer(@PathVariable String orderId, @RequestBody OrderRequestDTO newStatut) throws Exception {
		return orderService.updateOrderStatut(orderId, newStatut);
    	 
     }
    
}

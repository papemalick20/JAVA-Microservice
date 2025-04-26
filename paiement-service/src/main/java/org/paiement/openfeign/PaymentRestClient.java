package org.paiement.openfeign;

import java.util.List;

//import org.paiement.dto.PaymentRequestDTO;
import org.paiement.entities.OrderCustoner;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ORDER-SERVICE", configuration = Feignconf.class)
public interface PaymentRestClient {
    
    // Récupérer une commande par son ID
    @GetMapping(path = "/api/orders/{id}")
    OrderCustoner getOrderCustoner(@PathVariable(name = "id") String id);

    // Récupérer toutes les commandes
    @GetMapping(path = "/api/orders")
    List<OrderCustoner> allOrderCustoners();

//    // Mettre à jour une commande existante
    @PutMapping(path = "/api/orders/{orderId}")
    OrderCustoner updateOrder(@PathVariable String orderId, @RequestBody OrderCustoner orderCustoner);

    @PutMapping(path = "/api/orders/{orderId}/statut")
    OrderCustoner updateOrderStatut(@PathVariable String orderId, @RequestBody OrderCustoner statut);

	
}

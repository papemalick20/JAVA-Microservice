package org.statistique.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.statistique.dto.StatistiqueResponseDTO;
import org.statistique.entities.Customer;
import org.statistique.entities.OrderCustoner;
import org.statistique.entities.OrderDetail;
import org.statistique.entities.Payment;
import org.statistique.enums.OrderStatut;
import org.statistique.openfeign.CustomerRestClient;
import org.statistique.openfeign.OrderDetailRestClient;
import org.statistique.openfeign.OrderRestClient;
import org.statistique.openfeign.PaymentRestClient;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.stream.Collectors;

@Service
public class StatistiqueServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(StatistiqueServiceImpl.class);
    private final PaymentRestClient paymentRestClient;
    private final OrderRestClient orderRestClient;
    private final CustomerRestClient customerRestClient;
    private final OrderDetailRestClient orderDetailRestClient;

    public StatistiqueServiceImpl(PaymentRestClient paymentRestClient, 
                                   OrderRestClient orderRestClient, 
                                   CustomerRestClient customerRestClient, 
                                   OrderDetailRestClient orderDetailRestClient) {
        this.paymentRestClient = paymentRestClient;
        this.orderRestClient = orderRestClient;
        this.customerRestClient = customerRestClient;
        this.orderDetailRestClient = orderDetailRestClient;
    }

    public StatistiqueResponseDTO getStatistiques() {
        logger.info("Calcul des statistiques...");
        
        double totalVente = calculerTotalVente();
        Map<String, Integer> produitsLesPlusVendus = calculerProduitsLesPlusVendus();
        Map<String, Integer> meilleursClients = calculerMeilleursClients();

        return new StatistiqueResponseDTO(totalVente, produitsLesPlusVendus, meilleursClients, new Date());
    }

    private double calculerTotalVente() {
        List<Payment> payments = paymentRestClient.getAllpayments();
        return payments.stream().mapToDouble(Payment::getAmount).sum();
    }

    private Map<String, Integer> calculerProduitsLesPlusVendus() {
        List<OrderDetail> orderDetails = orderDetailRestClient.getAlldetails();
        Map<String, Integer> produitsLesPlusVendus = new HashMap<>();

        for (OrderDetail detail : orderDetails) {
            produitsLesPlusVendus.merge(detail.getProduct().getId(), detail.getQuantityOrder(), Integer::sum);
        }

        return produitsLesPlusVendus;
    }

  

    private Map<String, Integer> calculerMeilleursClients() {
        List<OrderCustoner> orders = orderRestClient.getAllorderCustoners();  // Récupère toutes les commandes
        Map<String, Integer> meilleursClients = new HashMap<>();

        for (OrderCustoner order : orders) {
            if (order.getStatut() == OrderStatut.PENDING) {
            	 
                // Récupérer les détails de la commande depuis le service de détails
                List<OrderDetail> orderDetails = orderDetailRestClient.getAlldetails();

                // Parcourir les détails de commande pour calculer les quantités totales
                for (OrderDetail detail : orderDetails) {
                    int quantity = detail.getQuantityOrder();  // Obtenir la quantité de chaque produit
                    // Additionner les quantités pour chaque client
                    meilleursClients.put(order.getCustomerId(),
                        meilleursClients.getOrDefault(order.getCustomerId(), 0) + quantity);
                }
            }
        }

        return meilleursClients;
    }


}

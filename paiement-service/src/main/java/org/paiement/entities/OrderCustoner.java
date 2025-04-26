package org.paiement.entities;

import java.util.Date;
import org.paiement.enums.PaiementStatus;  // Import de l'énumération

public class OrderCustoner {

    private String id;
    private Date orderDate;
    private PaiementStatus statut;

    public OrderCustoner() {
        super();
    }

    public OrderCustoner(String id, Date orderDate, PaiementStatus statut) {
        super();
        this.id = id;
        this.orderDate = orderDate;
        this.statut = statut;
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

    // Utilisation de PaiementStatus pour le getter et le setter du statut
    public PaiementStatus getStatut() {
        return statut;
    }

    public void setStatut(PaiementStatus statut) {
        this.statut = statut;
    }
}

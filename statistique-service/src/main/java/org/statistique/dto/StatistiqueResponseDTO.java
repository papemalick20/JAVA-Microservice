package org.statistique.dto;

import java.util.Date;
import java.util.Map;

public class StatistiqueResponseDTO {
    private double totalVente;
    private Map<String, Integer> produitsLesPlusVendus;
    private Map<String, Integer> meilleursClients;
    private Date date;
	public StatistiqueResponseDTO(double totalVente, Map<String, Integer> produitsLesPlusVendus,
			Map<String, Integer> meilleursClients2, Date date) {
		super();
		this.totalVente = totalVente;
		this.produitsLesPlusVendus = produitsLesPlusVendus;
		this.meilleursClients = meilleursClients2;
		this.date = date;
	}
	public double getTotalVente() {
		return totalVente;
	}
	public void setTotalVente(double totalVente) {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

    
}

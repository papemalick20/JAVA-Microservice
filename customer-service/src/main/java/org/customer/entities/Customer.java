package org.customer.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	private String id;
	private String name;
	private String email;
	private String phone;
	private String adresse;
	public Customer(String id, String name, String email, String phone, String adresse) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.adresse = adresse;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public String getId() { return id; } public void setId(String id) { this.id =
	 * id; } public String getName() { return name; } public void setName(String
	 * name) { this.name = name; } public String getEmail() { return email; } public
	 * void setEmail(String email) { this.email = email; } public String getPhone()
	 * { return phone; } public void setPhone(String phone) { this.phone = phone; }
	 * public String getAdresse() { return adresse; } public void setAdresse(String
	 * adresse) { this.adresse = adresse; }
	 */
	
	

}

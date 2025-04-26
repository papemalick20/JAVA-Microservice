package org.customer.repository;

import java.util.List;

import org.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	List<Customer> findByNameContains(String keyword);

}

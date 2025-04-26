package org.product.repository;

import java.util.List;

import org.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
	List<Product> findByIdContains(String keyword);

}

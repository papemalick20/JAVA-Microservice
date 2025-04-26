package org.product.services;

import java.util.List;

import org.product.dto.ProductRequestDTO;
import org.product.dto.ProductResponseDTO;

public interface ProductService {
	 ProductResponseDTO save(ProductRequestDTO productRequestDTO);
	 List<ProductResponseDTO> productResponseDTOs();
	ProductResponseDTO getProduct(String productId);
	ProductResponseDTO updateproduct(ProductRequestDTO productRequestDTO);
	ProductResponseDTO updateStock(ProductRequestDTO productRequestDTO, int quantity);
	List<ProductResponseDTO> searchProduct(String keyword);
	
	

}

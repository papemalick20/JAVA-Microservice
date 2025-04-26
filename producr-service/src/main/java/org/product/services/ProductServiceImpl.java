package org.product.services;


import java.util.List;
import java.util.stream.Collectors;

import org.product.dto.ProductRequestDTO;
import org.product.dto.ProductResponseDTO;
import org.product.entities.Product;
import org.product.mappers.ProductMappers;
import org.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	private ProductRepository productRepository;
	private ProductMappers productMappers;
	
	public ProductServiceImpl(ProductRepository productRepository, ProductMappers productMappers) {
		super();
		this.productRepository = productRepository;
		this.productMappers = productMappers;
	}

	@Override
	public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
		Product product=productMappers.fromProductRequestDTO(productRequestDTO);
		Product saveProduct=productRepository.save(product);
		
		ProductResponseDTO productResponseDTO=productMappers.fromProduct(saveProduct);
		
		return productResponseDTO;
	}

	@Override
	public List<ProductResponseDTO> productResponseDTOs() {
		List<Product> products=productRepository.findAll();
		List<ProductResponseDTO> productResponseDTOs=products
				.stream()
				.map(prod->productMappers
						.fromProduct(prod))
				.collect(Collectors.toList());
		return productResponseDTOs;
	}

	@Override
	public ProductResponseDTO getProduct(String productId) {
		Product product=productRepository.findById(productId).get();
		
		return productMappers.fromProduct(product);
	}

	@Override
	public ProductResponseDTO updateStock(ProductRequestDTO productRequestDTO, int quantityOrder) {
		Product product=productMappers.fromProductRequestDTO(productRequestDTO);
		Product updateProduct=productRepository.save(product);
		
		return productMappers.fromProduct(updateProduct);
	}

	@Override
	public List<ProductResponseDTO> searchProduct(String keyword) {
		List<Product> products=productRepository.findByIdContains(keyword);
		List<ProductResponseDTO> productResponseDTOs=products
				.stream()
				.map(prd->productMappers.fromProduct(prd)).collect(Collectors.toList());
		return productResponseDTOs;
	}

	@Override
	public ProductResponseDTO updateproduct(ProductRequestDTO productRequestDTO) {
		
		return null;
	}
	 

}

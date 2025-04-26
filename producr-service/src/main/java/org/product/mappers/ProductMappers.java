package org.product.mappers;

import org.mapstruct.Mapper;
import org.product.dto.ProductRequestDTO;
import org.product.dto.ProductResponseDTO;
import org.product.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMappers {
	public ProductResponseDTO fromProduct(Product product);
	public Product fromProductRequestDTO(ProductRequestDTO productRequestDTO);

}

package org.product.web;

import java.util.List;
import java.util.UUID;

import org.product.dto.ProductRequestDTO;
import org.product.dto.ProductResponseDTO;
import org.product.services.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	 @GetMapping(path="/products")
	public List<ProductResponseDTO> allProduct(){
		
		return productService.productResponseDTOs();
		
	}
	 @PostMapping(path="/products")
	 public ProductResponseDTO save(@RequestBody ProductRequestDTO productRequestDTO) {
		 productRequestDTO.setId(UUID.randomUUID().toString());
		return productService.save(productRequestDTO);
		 
	 }
	 @GetMapping(path="/products/{id}")
	  public ProductResponseDTO getProductResponse(@PathVariable(name="id") String id) {
		return productService.getProduct(id);
		  
	  }
	   @GetMapping(path="/products/search")
	 public List<ProductResponseDTO> searchProduct(@RequestParam(name="keyword", defaultValue = "")  String keyword){
		return productService.searchProduct(keyword);
		 
	 }

}

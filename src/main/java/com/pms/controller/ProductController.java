package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.ProductDto;
import com.pms.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/saveproduct")
	public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) {
		try {
			Boolean saveProduct = productService.saveProduct(productDto);

			if (ObjectUtils.isEmpty(saveProduct)) {
				return new ResponseEntity<>("Product not saved", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("Product Saved Successfully", HttpStatus.OK);

	}

	@GetMapping("/allProducts")
	public ResponseEntity<?> allProducts() {
		List<ProductDto> allProducts = null;
		try {
			allProducts = productService.getAllProducts();
			if (CollectionUtils.isEmpty(allProducts)) {
				return new ResponseEntity<>("Product is Empty", HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(name = "id") Integer id) {
		ProductDto product = null;
		try {
			product = productService.getByProductId(id);
			if (ObjectUtils.isEmpty(product)) {
				return new ResponseEntity<>("Product not found with this id = " + id, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Integer id) {
		Boolean product = false;
		try {
			product = productService.deleteProduct(id);
			if (!product) {
				return new ResponseEntity<>("Product not found with this id = " + id, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}


}

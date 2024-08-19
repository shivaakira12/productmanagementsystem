package com.pms.service;

import java.util.List;

import com.pms.dto.ProductDto;

public interface ProductService {

	public Boolean saveProduct(ProductDto productDto);

	public List<ProductDto> getAllProducts();

	public ProductDto getByProductId(Integer id);

	public Boolean deleteProduct(Integer id);
}

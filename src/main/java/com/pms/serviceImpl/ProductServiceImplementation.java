package com.pms.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.pms.dto.ProductDto;
import com.pms.model.Product;
import com.pms.repository.ProductRepository;
import com.pms.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired

	private ModelMapper mapper;

	@Override
	public Boolean saveProduct(ProductDto productDto) {

		Product product = mapper.map(productDto, Product.class);

		Product save = productRepository.save(product);

		if (!ObjectUtils.isEmpty(save)) {
			return true;
		}
		return false;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> allProducts = productRepository.findAll();

		List<ProductDto> productList = allProducts.stream().map(product -> mapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
		return productList;
	}

	@Override
	public ProductDto getByProductId(Integer id) {
		Optional<Product> productById = productRepository.findById(id);
		if (productById.isPresent()) {
			Product product = productById.get();
			ProductDto productFoundById = mapper.map(product, ProductDto.class);
			return productFoundById;
		}
		return null;

	}

	@Override
	public Boolean deleteProduct(Integer id) {
		Optional<Product> productById = productRepository.findById(id);
		if (productById.isPresent()) {
			Product product = productById.get();
			productRepository.delete(product);
			return true;
		}
		return false;
	}

}

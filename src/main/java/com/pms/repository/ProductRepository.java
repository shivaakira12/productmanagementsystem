package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

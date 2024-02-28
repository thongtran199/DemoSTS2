package com.sgu.service;

import java.util.List;

import com.sgu.entity.Product;

public interface ProductService {
	Product findById(Integer id);
	Product findByName(String name);
	List<Product> findByCategory(Integer id);
	List<Product> findByCategory(Integer id, int pageNumber, int pageSize);
	List<Product> findByNameColorPrice(String name, String color, Float begin, Float end);
	List<Product> findAll();
	List<Product> findAll(int pageNumber, int pageSize);
	Product create(Product entity);
	Product update(Product entity);
	Product delete(Integer id);
}

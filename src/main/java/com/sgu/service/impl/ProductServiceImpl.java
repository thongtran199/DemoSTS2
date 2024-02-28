package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.ProductDao;
import com.sgu.dao.impl.ProductDaoImpl;
import com.sgu.entity.Product;
import com.sgu.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao dao;
	
	public ProductServiceImpl()
	{
		dao = new ProductDaoImpl();
	}
	@Override
	public Product findById(Integer id) {
		return dao.findById(id);
	}
	@Override
	public List<Product> findByCategory(Integer id) {
		return dao.findByCategory(id);
	}
	@Override
	public Product findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Product> findAll() {
	return dao.findAll();
	}

	@Override
	public List<Product> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Product create(Product entity) {
		entity.setIsActive(Boolean.TRUE);
		return dao.create(entity);
	}

	@Override
	public Product update(Product entity) {
		return dao.update(entity);
	}

	@Override
	public Product delete(Integer id) {
		Product entity = dao.findById(id);
		entity.setIsActive(Boolean.FALSE);
		return dao.update(entity);
	}
	@Override
	public List<Product> findByCategory(Integer id, int pageNumber, int pageSize) {
		return dao.findByCategory(id, pageNumber, pageSize);
	}
	@Override
	public List<Product> findByNameColorPrice(String name, String color, Float begin, Float end) {
		return dao.findByNameColorPrice(name, color, begin, end);
	}


}

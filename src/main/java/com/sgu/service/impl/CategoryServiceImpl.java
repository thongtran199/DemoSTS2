package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.CategoryDao;
import com.sgu.dao.impl.CategoryDaoImpl;
import com.sgu.entity.Category;

import com.sgu.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao dao;
	
	public CategoryServiceImpl()
	{
		dao = new CategoryDaoImpl();
	}

	@Override
	public Category findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

	@Override
	public Category create(Category entity) {
		entity.setIsActive(Boolean.TRUE);
		entity.setImage("default.jpg");
		return dao.create(entity);
	}

	@Override
	public Category update(Category entity) {
		return dao.update(entity);
	}

	@Override
	public Category delete(Integer id) {
		Category entity = dao.findById(id);
		entity.setIsActive(Boolean.FALSE);
		return dao.update(entity);
	}


}

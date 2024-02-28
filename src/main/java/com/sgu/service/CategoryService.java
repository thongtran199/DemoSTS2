package com.sgu.service;

import java.util.List;

import com.sgu.entity.Category;

public interface CategoryService {
	Category findById(Integer id);
	List<Category> findAll();
	Category create(Category entity);
	Category update(Category entity);
	Category delete(Integer id);
}

package com.sgu.dao;

import java.util.List;

import com.sgu.entity.Category;

public interface CategoryDao {
	Category findById(Integer id);
	List<Category> findAll();
	Category create(Category entity);
	Category update(Category entity);
	Category delete(Category entity);
}

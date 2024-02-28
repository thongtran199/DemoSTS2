package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.CategoryDao;
import com.sgu.entity.Category;

public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao{

	@Override
	public Category findById(Integer id) {
		return super.findById(Category.class, id);
	}


	public List<Category> findAll() {
		return super.findAll(Category.class, true);
	}

}

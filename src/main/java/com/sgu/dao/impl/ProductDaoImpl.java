package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.ProductDao;
import com.sgu.entity.Product;

public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao{

	@Override
	public Product findById(Integer id) {
		return super.findById(Product.class, id);
	}

	@Override
	public Product findByName(String name) {
		String sql = "SELECT o FROM Product o WHERE o.productName LIKE %?0%";
		return super.findOne(Product.class, sql, name);
	}

	@Override
	public List<Product> findByCategory(Integer id) {
		String sql = "SELECT o FROM Product o WHERE o.category.categoryID = ?0";
		return super.findMany(Product.class, sql, id);
	}

	@Override
	public List<Product> findAll() {
		return super.findAll(Product.class, true);
	}

	@Override
	public List<Product> findAll(int pageNumber, int pageSize) {
		return super.findAll(Product.class, true, pageNumber, pageSize);
	}

	@Override
	public List<Product> findByCategory(Integer id, int pageNumber, int pageSize) {
		String condition = "WHERE o.category.categoryID = "+id;
		return super.findByXID(Product.class, true, pageNumber, pageSize, condition);
	}

	@Override
	public List<Product> findByNameColorPrice(String name, String color, Float begin, Float end) {
		String condition="WHERE 1 = 1";
		if(!name.isEmpty())
		{
			condition = condition + " AND o.productName LIKE '%"+name+"%'";
		}
		if(!color.isEmpty())
		{
			condition = condition + " AND o.color LIKE '"+color+"'";
		}
		if(begin!=0)
		{
			condition = condition + " AND o.unitPrice > "+begin;
		}
		if(end != 0)
		{
			condition = condition + " AND o.unitPrice < "+end;
		}
		
		return super.findByCondition(Product.class, true, condition);
	}




}

package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.SupplierDao;
import com.sgu.entity.Supplier;

public class SupplierDaoImpl extends AbstractDao<Supplier> implements SupplierDao{

	@Override
	public Supplier findById(Integer id) {
		return super.findById(Supplier.class, id);
	}


	@Override
	public List<Supplier> findAll() {
		return super.findAll(Supplier.class, true);
	}

	@Override
	public List<Supplier> findAll(int pageNumber, int pageSize) {
		return super.findAll(Supplier.class, true, pageNumber, pageSize);
	}

	@Override
	public Supplier findByContactNumber(String number) {
		String sql = "SELECT o FROM Supplier o WHERE o.contactNumber = ?0";
		return super.findOne(Supplier.class, sql, number);
	}

	@Override
	public List<Supplier> findByCity(String city) {
		String sql = "SELECT o FROM Supplier o WHERE o.city LIKE %?0%";
		return super.findMany(Supplier.class, sql, city);
	}

}

package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.SupplierDao;
import com.sgu.dao.impl.SupplierDaoImpl;
import com.sgu.entity.Supplier;
import com.sgu.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

	private SupplierDao dao;
	
	public SupplierServiceImpl()
	{
		dao = new SupplierDaoImpl();
	}

	@Override
	public Supplier findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Supplier> findAll() {
		return dao.findAll();
	}

	@Override
	public Supplier findByContactNumber(String number) {
		return dao.findByContactNumber(number);
	}

	@Override
	public List<Supplier> findByCity(String city) {
		return dao.findByCity(city);
	}

	@Override
	public List<Supplier> findAll(int pageNumber, int pageSize) {
		return dao.findAll();
	}

	@Override
	public Supplier create(Supplier entity) {
		entity.setIsActive(Boolean.TRUE);
		return dao.create(entity);
	}

	@Override
	public Supplier update(Supplier entity) {
		return dao.update(entity);
		}

	@Override
	public Supplier delete(Integer id) {
		Supplier entity = dao.findById(id);
		entity.setIsActive(Boolean.FALSE);
		return dao.update(entity);
	}
}

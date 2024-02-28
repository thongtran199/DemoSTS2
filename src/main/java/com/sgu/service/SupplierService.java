package com.sgu.service;

import java.util.List;

import com.sgu.entity.Supplier;

public interface SupplierService {
	Supplier findById(Integer id);
	Supplier findByContactNumber(String number);
	List<Supplier> findByCity(String city);
	List<Supplier> findAll();
	List<Supplier> findAll(int pageNumber, int pageSize);
	Supplier create(Supplier entity);
	Supplier update(Supplier entity);
	Supplier delete(Integer id);
}

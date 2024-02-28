package com.sgu.service.impl;


import java.util.List;

import com.sgu.dao.PaymentDao;
import com.sgu.dao.impl.PaymentDaoImpl;
import com.sgu.entity.Payment;
import com.sgu.service.PaymentService;


public class PaymentServiceImpl implements PaymentService {

	private PaymentDao dao;
	
	public PaymentServiceImpl()
	{
		dao = new PaymentDaoImpl();
	}
	@Override
	public Payment findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Payment> findAll() {
		return dao.findAll();
	}
	@Override
	public List<Payment> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}
	@Override
	public Payment create(Payment entity) {
		return dao.create(entity);
	}
	@Override
	public Payment update(Payment entity) {
		return dao.update(entity);
	}
	@Override
	public Payment delete(Integer id) {
		return null;
	}

}

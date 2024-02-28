package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.PaymentDao;
import com.sgu.entity.Payment;

public class PaymentDaoImpl extends AbstractDao<Payment> implements PaymentDao{

	@Override
	public Payment findById(Integer id) {
		return super.findById(Payment.class, id);
	}


	@Override
	public List<Payment> findAll() {
		return super.findAll(Payment.class, true);
	}

	@Override
	public List<Payment> findAll(int pageNumber, int pageSize) {
		return super.findAll(Payment.class, true, pageNumber, pageSize);
	}
}

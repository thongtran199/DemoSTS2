package com.sgu.dao;

import java.util.List;

import com.sgu.entity.Payment;

public interface PaymentDao {
	Payment findById(Integer id);
	List<Payment> findAll();
	List<Payment> findAll(int pageNumber, int pageSize);
	Payment create(Payment entity);
	Payment update(Payment entity);
	Payment delete(Payment entity);
}

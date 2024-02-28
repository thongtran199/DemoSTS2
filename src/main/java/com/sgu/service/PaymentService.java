package com.sgu.service;

import java.util.List;

import com.sgu.entity.Payment;

public interface PaymentService {
	Payment findById(Integer id);
	List<Payment> findAll();
	List<Payment> findAll(int pageNumber, int pageSize);
	Payment create(Payment entity);
	Payment update(Payment entity);
	Payment delete(Integer id);
}

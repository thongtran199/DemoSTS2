package com.sgu.service;

import java.util.List;


import com.sgu.entity.Order;

public interface OrderService {
	Order findById(Integer id);
	List<Order> findByUserId(Integer id);
	List<Order> findByDate(int year, int month, int day);
	List<Order> findBySellerId(Integer id);
	List<Order> findByPaymentId(Integer id);
	List<Order> findByShippingId(Integer id);
	List<Order> findAll();
	Order create(Order entity);
	Order update(Order entity);
	Order delete(Integer id);
}

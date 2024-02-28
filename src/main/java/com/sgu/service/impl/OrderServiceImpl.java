package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.OrderDao;
import com.sgu.dao.impl.OrderDaoImpl;
import com.sgu.entity.Order;
import com.sgu.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao dao;
	public OrderServiceImpl() {
		dao = new OrderDaoImpl();
	}
	@Override
	public Order findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Order> findByUserId(Integer id) {
		return dao.findByUserId(id);
	}

	@Override
	public List<Order> findAll() {
		return dao.findAll();
	}

	@Override
	public Order create(Order entity) {
		entity.setIsActive(Boolean.TRUE);
		return dao.create(entity);
	}

	@Override
	public Order update(Order entity) {
		return dao.update(entity);
	}
	@Override
	public List<Order> findBySellerId(Integer id) {
		return dao.findBySellerId(id);
	}
	@Override
	public List<Order> findByPaymentId(Integer id) {
		return dao.findByPaymentId(id);
	}
	@Override
	public List<Order> findByShippingId(Integer id) {
		return dao.findByShippingId(id);
	}
	@Override
	public Order delete(Integer id) {
		Order order = dao.findById(id);
		order.setIsActive(Boolean.FALSE);
		return dao.update(order);
	}
	@Override
	public List<Order> findByDate(int year, int month, int day) {
		return dao.findByDate(year, month, day);
	}

}

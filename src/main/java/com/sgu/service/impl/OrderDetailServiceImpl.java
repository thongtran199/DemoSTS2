package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.OrderDetailDao;
import com.sgu.dao.impl.OrderDetailDaoImpl;
import com.sgu.entity.OrderDetail;
import com.sgu.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
	private OrderDetailDao dao;
	public OrderDetailServiceImpl() {
		dao = new OrderDetailDaoImpl();
	}
	@Override
	public OrderDetail findById(Integer id) {
		return dao.findById(id);
	}
	@Override
	public List<OrderDetail> findByProductId(Integer id) {
		return dao.findByProductId(id);
	}
	@Override
	public List<OrderDetail> findByOrderId(Integer id) {
		return dao.findByOrderId(id);
	}
	@Override
	public List<OrderDetail> findAll() {
		return dao.findAll();
	}
	@Override
	public OrderDetail create(OrderDetail entity) {
		return dao.create(entity);
	}
	@Override
	public OrderDetail update(OrderDetail entity) {
		return dao.update(entity);
	}
	@Override
	public OrderDetail delete(OrderDetail entity) {

		return null;
	}


}

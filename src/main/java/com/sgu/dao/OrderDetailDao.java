package com.sgu.dao;

import java.util.List;


import com.sgu.entity.*;


public interface OrderDetailDao {
	OrderDetail findById(Integer id);
	List<OrderDetail> findByProductId(Integer id);
	List<OrderDetail> findByOrderId(Integer id);
	List<OrderDetail> findAll();
	OrderDetail create(OrderDetail entity);
	OrderDetail update(OrderDetail entity);
	OrderDetail delete(OrderDetail entity);
	
}

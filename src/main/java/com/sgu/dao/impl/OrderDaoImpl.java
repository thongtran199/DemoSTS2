package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.OrderDao;

import com.sgu.entity.Order;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

	@Override
	public Order findById(Integer id) {
		return super.findById(Order.class, id);
	}
 
	@Override
	public List<Order> findAll() {
		return super.findAll(Order.class, true);
	}


	@Override
	public List<Order> findByUserId(Integer id) {
		String sql = "SELECT o FROM Order o WHERE o.user.userID =?0";
		return super.findMany(Order.class,sql, id);
	}

	@Override
	public List<Order> findBySellerId(Integer id) {
		String sql = "SELECT o FROM Order o WHERE o.seller.userID =?0";
		return super.findMany(Order.class,sql, id);
	}

	@Override
	public List<Order> findByPaymentId(Integer id) {
		String sql = "SELECT o FROM Order o WHERE o.payment.paymentID =?0";
		return super.findMany(Order.class,sql, id);
	}

	@Override
	public List<Order> findByShippingId(Integer id) {
		String sql = "SELECT o FROM Order o WHERE o.shipment.shippingID =?0";
		return super.findMany(Order.class,sql, id);
	}

	@Override
	public List<Order> findByDate(int year, int month, int day) {
		String sql = "SELECT o FROM Order o WHERE YEAR(o.orderDate) = ?0 AND MONTH(o.orderDate) = ?1 AND DAY(o.orderDate) = ?2";
		return super.findMany(Order.class,sql, year, month, day);
	}


}

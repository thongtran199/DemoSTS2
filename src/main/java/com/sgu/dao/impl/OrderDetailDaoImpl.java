package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.OrderDetailDao;
import com.sgu.entity.OrderDetail;

public class OrderDetailDaoImpl extends AbstractDao<OrderDetail> implements OrderDetailDao {

	@Override
	public OrderDetail findById(Integer id) {
		return super.findById(OrderDetail.class, id);
	}
	@Override
	public List<OrderDetail> findAll() {
		return super.findAll(OrderDetail.class, true);
	}

	@Override
	public List<OrderDetail> findByProductId(Integer id) {
		String sql = "SELECT o FROM OrderDetail o WHERE o.product.productID =?0";
		return super.findMany(OrderDetail.class,sql, id);
	}
	@Override
	public List<OrderDetail> findByOrderId(Integer id) {
		String sql = "SELECT o FROM OrderDetail o WHERE o.order.orderID = ?0";
		return super.findMany(OrderDetail.class,sql, id);
	}

}

package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.CartDetailDao;
import com.sgu.entity.CartDetail;

public class CartDetailDaoImpl extends AbstractDao<CartDetail> implements CartDetailDao {

	@Override
	public CartDetail findById(Integer id) {
		return super.findById(CartDetail.class, id);
	}
	@Override
	public List<CartDetail> findAll() {
		return super.findAll(CartDetail.class, true);
	}

	@Override
	public List<CartDetail> findByProductId(Integer id) {
		String sql = "SELECT o FROM CartDetail o WHERE o.product.productID =?0";
		return super.findMany(CartDetail.class,sql, id);
	}
	@Override
	public List<CartDetail> findByCartId(Integer id) {
		String sql = "SELECT o FROM CartDetail o WHERE o.cart.cartID = ?0";
		return super.findMany(CartDetail.class,sql, id);
	}

}

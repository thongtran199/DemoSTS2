package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.CartDao;
import com.sgu.entity.Cart;

public class CartDaoImpl extends AbstractDao<Cart> implements CartDao {

	@Override
	public Cart findById(Integer id) {
		return super.findById(Cart.class, id);
	}
 
	@Override
	public List<Cart> findAll() {
		return super.findAll(Cart.class, true);
	}


	@Override
	public Cart findByUserId(Integer id) {
		String sql = "SELECT o FROM Cart o WHERE o.user.userID =?0";
		return super.findOne(Cart.class,sql, id);
	}


}

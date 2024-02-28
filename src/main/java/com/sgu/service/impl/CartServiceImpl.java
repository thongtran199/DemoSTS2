package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.CartDao;
import com.sgu.dao.impl.CartDaoImpl;
import com.sgu.entity.Cart;
import com.sgu.service.CartService;

public class CartServiceImpl implements CartService {
	private CartDao dao;
	public CartServiceImpl() {
		dao = new CartDaoImpl();
	}
	@Override
	public Cart findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Cart findByUserId(Integer id) {
		return dao.findByUserId(id);
	}

	@Override
	public List<Cart> findAll() {
		return dao.findAll();
	}

	@Override
	public Cart create(Cart entity) {
		return dao.create(entity);
	}

	@Override
	public Cart update(Cart entity) {
		return dao.update(entity);
	}

}

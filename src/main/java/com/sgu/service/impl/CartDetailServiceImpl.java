package com.sgu.service.impl;

import java.util.Iterator;
import java.util.List;


import com.sgu.dao.CartDetailDao;

import com.sgu.dao.impl.CartDetailDaoImpl;
import com.sgu.entity.Cart;
import com.sgu.entity.CartDetail;
import com.sgu.service.CartDetailService;
import com.sgu.service.CartService;

public class CartDetailServiceImpl implements CartDetailService {
	private CartDetailDao dao;
	private CartService cartService = new CartServiceImpl();
	public CartDetailServiceImpl() {
		dao = new CartDetailDaoImpl();
	}
	@Override
	public CartDetail findById(Integer id) {
		return dao.findById(id);
	}
	@Override
	public List<CartDetail> findByProductId(Integer id) {
		return dao.findByProductId(id);
	}
	@Override
	public List<CartDetail> findByCartId(Integer id) {
		return dao.findByCartId(id);
	}
	@Override
	public List<CartDetail> findAll() {
		return dao.findAll();
	}
	@Override
	public CartDetail create(CartDetail entity) {
		return dao.create(entity);
	}
	@Override
	public CartDetail update(CartDetail entity) {		
		return dao.update(entity);
	}
	@Override
	public CartDetail delete(Integer id) {
		CartDetail cartDetail = dao.findById(id);
		Cart cart = cartDetail.getCart();
		cart.setQuantity(cart.getQuantity() - 1);
		cartService.update(cart);
		return dao.delete(cartDetail);
	}
	@Override
	public CartDetail findByCartIdAndProductID(Integer cartId, Integer productID) {
		List<CartDetail> cartDetails = dao.findByCartId(cartId);
		for (CartDetail cartDetail : cartDetails) {
			if(cartDetail.getProduct().getProductID() == productID)
				return cartDetail;
		}
		return null;
		
	}

}

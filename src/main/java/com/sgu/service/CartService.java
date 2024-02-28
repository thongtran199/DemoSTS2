package com.sgu.service;

import java.util.List;

import com.sgu.entity.Cart;

public interface CartService {
	Cart findById(Integer id);
	Cart findByUserId(Integer id);
	List<Cart> findAll();
	Cart create(Cart entity);
	Cart update(Cart entity);
}

package com.sgu.service;

import java.util.List;

import com.sgu.entity.CartDetail;

public interface CartDetailService {
	CartDetail findById(Integer id);
	CartDetail findByCartIdAndProductID(Integer cartId, Integer productID);
	List<CartDetail> findByProductId(Integer id);
	List<CartDetail> findByCartId(Integer id);
	List<CartDetail> findAll();
	CartDetail create(CartDetail entity);
	CartDetail update(CartDetail entity);
	CartDetail delete(Integer id);
}

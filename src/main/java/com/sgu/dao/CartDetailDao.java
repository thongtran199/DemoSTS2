package com.sgu.dao;

import java.util.List;


import com.sgu.entity.*;


public interface CartDetailDao {
	CartDetail findById(Integer id);
	List<CartDetail> findByProductId(Integer id);
	List<CartDetail> findByCartId(Integer id);
	List<CartDetail> findAll();
	CartDetail create(CartDetail entity);
	CartDetail update(CartDetail entity);
	CartDetail delete(CartDetail entity);
	
}

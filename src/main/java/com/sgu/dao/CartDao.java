package com.sgu.dao;

import java.util.List;


import com.sgu.entity.*;


public interface CartDao {
	Cart findById(Integer id);
	Cart findByUserId(Integer id);
	List<Cart> findAll();
	Cart create(Cart entity);
	Cart update(Cart entity);
	Cart delete(Cart entity);
	
}

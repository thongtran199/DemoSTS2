package com.sgu.dao.impl;

import java.util.List;

import com.sgu.dao.AbstractDao;
import com.sgu.dao.ReviewDao;
import com.sgu.entity.Review;

public class ReviewDaoImpl extends AbstractDao<Review> implements ReviewDao{

	@Override
	public Review findById(Integer id) {
		return super.findById(Review.class, id);
	}


	@Override
	public List<Review> findAll() {
		return super.findAll(Review.class, true);
	}

	@Override
	public List<Review> findAll(int pageNumber, int pageSize) {
		return super.findAll(Review.class, true, pageNumber, pageSize);
	}

	@Override
	public List<Review> findByProduct(Integer id) {
		String sql = "SELECT o FROM Review o WHERE o.product.productID = ?0";
		return super.findMany(Review.class, sql, id);
	}


	@Override
	public List<Review> findByUser(Integer id) {
		String sql = "SELECT o FROM Review o WHERE o.user.userID = ?0";
		return super.findMany(Review.class, sql, id);
	}

}

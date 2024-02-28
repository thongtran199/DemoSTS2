package com.sgu.service;

import java.util.List;

import com.sgu.entity.Review;

public interface ReviewService {
	Review findById(Integer id);
	List<Review> findByProduct(Integer id);
	List<Review> findByUser(Integer id);
	List<Review> findAll();
	List<Review> findAll(int pageNumber, int pageSize);
	Review create(Review entity);
	Review update(Review entity);
	Review delete(Integer id);
}

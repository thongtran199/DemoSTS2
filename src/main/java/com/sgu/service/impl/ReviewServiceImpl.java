package com.sgu.service.impl;

import java.util.List;

import com.sgu.dao.ReviewDao;
import com.sgu.dao.impl.ReviewDaoImpl;
import com.sgu.entity.Review;
import com.sgu.service.ReviewService;

public class ReviewServiceImpl implements ReviewService {

	private ReviewDao dao;
	
	public ReviewServiceImpl()
	{
		dao = new ReviewDaoImpl();
	}

	@Override
	public Review findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Review> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Review> findByProduct(Integer id) {
		return dao.findByProduct(id);
	}

	@Override
	public List<Review> findByUser(Integer id) {
		return dao.findByUser(id);
	}

	@Override
	public List<Review> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Review create(Review entity) {
		return dao.create(entity);
	}

	@Override
	public Review update(Review entity) {
		return dao.update(entity);
	}

	@Override
	public Review delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}

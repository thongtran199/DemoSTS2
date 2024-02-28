package com.sgu.service;

import java.util.List;

import com.sgu.entity.User;

public interface UserService {
	User findById(Integer id);
	User findByEmail(String email);
	User findByUserName(String username);
	User login(String username, String password);
	User resetPassword(String email);
	List<User> findAll();
	List<User> findAll(int pageNumber, int pageSize);
	User create(User entity);
	User register(String username, String password, String email, String telNumber , Integer role,
			String fullName, String shipAddress, String shipCity, String shipState);
	User update(User entity);
	User delete(String username);
	User delete(Integer id);
	
//	List<User> findUsersByVideoHref(String href);
}

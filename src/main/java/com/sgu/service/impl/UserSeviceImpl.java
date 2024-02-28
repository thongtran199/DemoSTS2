package com.sgu.service.impl;

import java.util.List;



import com.sgu.constant.TenParamsCuaProcedure;
import com.sgu.dao.UserDao;
import com.sgu.dao.impl.UserDaoImpl;
import com.sgu.entity.User;
import com.sgu.service.UserService;


public class UserSeviceImpl implements UserService {

	private UserDao dao;

	public UserSeviceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public User findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User findByUserName(String username) {
		return dao.findByUserName(username);
	}

	@Override
	public User login(String username, String password) {
		return dao.findByUserNameAndPassword(username, password);
	}

	@Override
	public User resetPassword(String email) {
		User user = dao.findByEmail(email);
		if(user != null)
		{
			String newPass= String.valueOf((int) ((Math.random() * (999999 - 0)) + 0));
			user.setPassword(newPass);
			return dao.update(user);
		}
		System.out.print("USER NULL");
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User register(String username, String password, String email, String telNumber , Integer role,
			String fullName, String shipAddress, String shipCity, String shipState) {
		User newUser = new User();
		newUser.setUserName(username);;
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setFullName(fullName);
		newUser.setShipAddress(shipAddress);
		newUser.setShipCity(shipCity);
		newUser.setShipState(shipState);
		newUser.setTelNumber(telNumber);
		newUser.setRole(role);
		newUser.setIsActive(Boolean.TRUE);
		newUser.setImage("default.png");
		return dao.create(newUser);
	}

	@Override
	public User update(User entity) {
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		User user = dao.findByUserName(username);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}

	@Override
	public User create(User entity) {
		entity.setIsActive(Boolean.TRUE);
		return dao.create(entity);
	}

	@Override
	public User delete(Integer id) {
		User user = dao.findById(id);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}

//	@Override
//	public List<User> findUsersByVideoHref(String href) {
//		Map<String, Object> params = new HashMap<>();
//		params.put("href", href);
//		List<User> users = dao.findUserLikedByVideoHref(params);
//		return users;
//	}

}

package com.sgu.dao.impl;

import java.util.List;
import java.util.Map;

import com.sgu.constant.TenProcedures;
import com.sgu.dao.AbstractDao;
import com.sgu.dao.UserDao;
import com.sgu.entity.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

	@Override
	public User findById(Integer id) {
		return super.findById(User.class, id);
	}
 
	@Override
	public User findByEmail(String email) {
		String sql = "SELECT o FROM User o WHERE o.email =?0";
		return super.findOne(User.class,sql, email);
	}

	@Override
	public User findByUserName(String username) {
		String sql = "SELECT o FROM User o WHERE o.userName =?0";
		return super.findOne(User.class,sql, username);
	}

	@Override
	public User findByUserNameAndPassword(String username, String password) {
		String sql = "SELECT u FROM User u WHERE u.userName = ?0 AND u.password =?1";
		return super.findOne(User.class,sql, username, password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return super.findAll(User.class, true, pageNumber, pageSize);
	}


//	@Override
//	public List<User> findUserLikedByVideoHref(Map<String, Object> params) {
//		return super.callStore(User.class,TenProcedures.FIND_USERS_LIKED_VIDEO_BY_VIDEO_HREF, params);
//	}

}

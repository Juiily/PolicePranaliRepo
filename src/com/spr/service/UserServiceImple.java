package com.spr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spr.dao.UserDao;
import com.spr.dto.PoliceEmployee;
import com.spr.dto.User;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	JdbcTemplate jt;

	@Autowired
	public UserDao userDao;

	@Override
	public User Login(User user) {
		return userDao.Login(user)  ;
	}

	@Override
	public PoliceEmployee getUserName(String userEmail) {

		return userDao.getUserName(userEmail);
	}

	@Override
	public boolean isUsernameExist(String username) {
		String sql = "select count(user_email) from user where user_email = ?";
		Integer count = jt.queryForObject(sql,new Object[] {username}, Integer.class);
		if(count == 1)
			return true;
		else
			return false;

	}


}

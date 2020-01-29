package com.spr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.dao.UserDao;
import com.spr.dto.PoliceEmployee;
import com.spr.dto.User;

@Service
public class UserServiceImple implements UserService {

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
 
}

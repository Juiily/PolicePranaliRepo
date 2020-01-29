package com.spr.dao;

import com.spr.dto.PoliceEmployee;
import com.spr.dto.User;

public interface UserDao {
	
	User Login(User user);
	PoliceEmployee getUserName(String userEmail);
}

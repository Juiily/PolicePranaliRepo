package com.spr.service;

import com.spr.dto.PoliceEmployee;
import com.spr.dto.User;

public interface UserService {

	User Login(User user);
	PoliceEmployee getUserName(String userEmail);
	boolean isUsernameExist(String username);
}

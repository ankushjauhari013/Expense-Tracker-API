package com.in.ankush.service;

import com.in.ankush.entity.User;
import com.in.ankush.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel user);
	User readUser();
	User updateUser(UserModel user);
	void deleteUser();
	User getLoggedInUser();
}

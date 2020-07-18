package com.janicaleksa.realestatereservationapp.service;

import com.janicaleksa.realestatereservationapp.domain.User;

public interface UserService {

	void saveUser(User user);
	
	void authenticateUser(User user);
	
	User loadUserByUsername(String username);
	
	User loginUser(User user);
	
	void deleteUser(User user);
}

package com.janicaleksa.realestatereservationapp.service;

import com.janicaleksa.realestatereservationapp.domain.User;

public interface UserService {

	void saveUser(User user);
	
	User loginUser(User user);
	
	void deleteUser(User user);
}

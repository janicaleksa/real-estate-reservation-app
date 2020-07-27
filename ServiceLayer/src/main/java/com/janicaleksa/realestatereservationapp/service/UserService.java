package com.janicaleksa.realestatereservationapp.service;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.exceptions.UserException;

public interface UserService {

	void saveUser(User user) throws UserException;
	
	void authenticateUser(User user);
	
	User loadUserByUsername(String username) throws UserException;
	
	User loginUser(User user);
	
	void deleteUser(User user);

	void updateUser(User user);
}

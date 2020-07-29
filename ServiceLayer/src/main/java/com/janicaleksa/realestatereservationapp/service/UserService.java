package com.janicaleksa.realestatereservationapp.service;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.exceptions.UserException;

public interface UserService {

	void saveUser(User user) throws UserException;
	
	void authenticateUser(String username, String password) throws UserException;
	
	User loadUserByUsername(String username) throws Exception;
	
	User loginUser(String username, String password) throws UserException;
	
	void deleteUser(User user);

	void updateUser(User user);
}

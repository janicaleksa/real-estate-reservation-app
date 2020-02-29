package com.janicaleksa.realestatereservationapp.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.janicaleksa.realestatereservationapp.domain.User;

public interface UserService extends UserDetailsService, AuthenticationManager {

	void saveUser(User user);
	
	void authenticate(String username, String password);
	
	User loginUser(User user);
	
	void deleteUser(User user);
}

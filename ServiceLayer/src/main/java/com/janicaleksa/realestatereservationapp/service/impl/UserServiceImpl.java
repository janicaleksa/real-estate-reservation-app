package com.janicaleksa.realestatereservationapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.mappers.UserAccountMapper;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;
import com.janicaleksa.realestatereservationapp.repositories.UserRepository;
import com.janicaleksa.realestatereservationapp.service.UserSecurityService;
import com.janicaleksa.realestatereservationapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserSecurityService userSecurityService;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserSecurityService userSecurityService) {
		this.userRepository = userRepository;
		this.userSecurityService = userSecurityService;
	}
	
	public void saveUser(User user) {
		getUserRepository().save(UserAccountMapper.INSTANCE.userToUserAccount(user));
	}
	
	public void authenticateUser(User user) {
		getUserSecurityService().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}
	
	public User loadUserByUsername(String username) {
		return (User) getUserSecurityService().loadUserByUsername(username);
	}
	
	public User loginUser(User user) {
		return (User) userSecurityService.loadUserByUsername(user.getUsername());
	}
	
	public void deleteUser(User user) {
		getUserRepository().delete(user);
	}

	private UserRepository getUserRepository() {
		return userRepository;
	}

	private UserSecurityService getUserSecurityService() {
		return userSecurityService;
	}	
	
}

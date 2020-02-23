package com.janicaleksa.realestatereservationapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.repositories.UserRepository;
import com.janicaleksa.realestatereservationapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void saveUser(User user) {
		userRepository.save(user.getUserAccount());
	}

	private UserRepository getUserRepository() {
		return userRepository;
	}

}

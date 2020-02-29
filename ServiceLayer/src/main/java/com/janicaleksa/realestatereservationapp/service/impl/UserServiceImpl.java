package com.janicaleksa.realestatereservationapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;
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
	
	public User loginUser(User user) {
		Optional<UserAccount> userAccount = userRepository.findByUsernameAndPassword(user.getUserAccount().getUsername(), user.getUserAccount().getPassword());
		User newUser = new User(userAccount.get());
		return newUser;
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user.getUserAccount());
	}

	private UserRepository getUserRepository() {
		return userRepository;
	}
}

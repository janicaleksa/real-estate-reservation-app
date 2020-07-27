package com.janicaleksa.realestatereservationapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;
import com.janicaleksa.realestatereservationapp.exceptions.UserException;
import com.janicaleksa.realestatereservationapp.mappers.UserAccountMapper;
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
	
	@Override
	public void saveUser(User user) throws UserException {
		try {
			Optional<UserAccount> userAccount = getUserRepository().findByUsername(user.getUsername());
			if(userAccount.isPresent()) {
				throw new UserException("User with username: " + user.getUsername() + " already exist!");
			}
			
			getUserRepository().save(UserAccountMapper.INSTANCE.userToUserAccount(user));
		} catch (UserException ue) {
			throw ue;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("Couldn't save user!");
		}	
	}
	
	@Override
	public void authenticateUser(User user) {
		getUserSecurityService().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}
	
	@Override
	public User loadUserByUsername(String username) throws UserException {
		try {
			return (User) getUserSecurityService().loadUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("Could not find user by username!");
		}
	}
	
	@Override
	public User loginUser(User user) {
		return loadUserByUsername(user.getUsername());
	}
	
	@Override
	public void deleteUser(User user) {
		getUserRepository().delete(user);
	}
	
	@Override
	public void updateUser(User user) {
		getUserRepository().save(UserAccountMapper.INSTANCE.userToUserAccount(user));
	}

	private UserRepository getUserRepository() {
		return userRepository;
	}

	private UserSecurityService getUserSecurityService() {
		return userSecurityService;
	}	
	
}

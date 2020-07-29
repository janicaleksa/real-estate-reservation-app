package com.janicaleksa.realestatereservationapp.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
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
				throw new UserException("User with username: '" + user.getUsername() + "' already exist!");
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
	public void authenticateUser(String username, String password) throws UserException {
		try {
			Optional<UserAccount> userAccount = getUserAccount(username);
			UserAccount user = userAccount.get();
			
			validateUserPassword(password, user.getPassword());
			
			getUserSecurityService().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		} catch (UserException ue) {
			throw ue;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("Couldn't authenticate user!");
		}
	}
	
	@Override
	public User loadUserByUsername(String username) throws Exception {
		try {
			return (User) getUserSecurityService().loadUserByUsername(username);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public User loginUser(String username, String password) throws UserException {
		try {
			Optional<UserAccount> userAccount = getUserAccount(username);
			UserAccount user = userAccount.get();
			
			validateUserPassword(password, user.getPassword());
			
			return loadUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException("Could not login user!");
		}
	}

	private void validateUserPassword(String password, String userPassword) {
		if(!StringUtils.equals(password, userPassword)) {
			throw new UserException("Password is invalid, please try again!");
		}
	}

	private Optional<UserAccount> getUserAccount(String username) {
		Optional<UserAccount> userAccount = getUserRepository().findByUsername(username);
		if(!userAccount.isPresent()) {
			throw new UserException("User with username: '" + username + "' doesn't exist, please register!");
		}
		return userAccount;
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

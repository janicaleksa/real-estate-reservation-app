package com.janicaleksa.realestatereservationapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;
import com.janicaleksa.realestatereservationapp.mappers.UserAccountMapper;
import com.janicaleksa.realestatereservationapp.repositories.UserRepository;
import com.janicaleksa.realestatereservationapp.service.UserSecurityService;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserSecurityServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserAccount> userAccount = getUserRepository().findByUsername(username);
		return UserAccountMapper.INSTANCE.userAccountToUser(userAccount.get());
	}
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return authentication;
	}

	private UserRepository getUserRepository() {
		return userRepository;
	}

}

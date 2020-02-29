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
		UserAccount userAccount2 = userAccount.get();
		User user = new User();
		
		user.setUsername(userAccount2.getUsername());
		user.setPassword(userAccount2.getPassword());
		user.setRole(userAccount2.getRole());
		
		com.janicaleksa.realestatereservationapp.entities.UserDetails userDetails = new com.janicaleksa.realestatereservationapp.entities.UserDetails();
		userDetails.setFirstName(userAccount2.getUserDetails().getFirstName());
		userDetails.setLastName(userAccount2.getUserDetails().getLastName());
		userDetails.setEmail(userAccount2.getUserDetails().getEmail());
		userDetails.setDateOfBirth(userAccount2.getUserDetails().getDateOfBirth());
		userDetails.setPhoneNumber(userAccount2.getUserDetails().getPhoneNumber());
		userDetails.setGender(userAccount2.getUserDetails().getGender());
		userDetails.setCity(userAccount2.getUserDetails().getCity());
		
		user.setUserDetails(userDetails);
		return user;
	}
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return authentication;
	}

	private UserRepository getUserRepository() {
		return userRepository;
	}

}

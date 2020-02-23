package com.janicaleksa.realestatereservationapp.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.dto.UserRegistrationForm;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;
import com.janicaleksa.realestatereservationapp.entities.UserDetails;
import com.janicaleksa.realestatereservationapp.facades.UserFacade;
import com.janicaleksa.realestatereservationapp.service.UserService;

@Component
public class UserFacadeImpl implements UserFacade{

	private final UserService userService;
	
	@Autowired
	public UserFacadeImpl(UserService userService) {
		this.userService = userService;
	}
	
	public void registerUser(UserRegistrationForm userRegistrationForm) {
		User user = new User();
		
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername(userRegistrationForm.getUsername());
		userAccount.setPassword(userRegistrationForm.getPassword());
		userAccount.setRole(userRegistrationForm.getRole());
		
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(userRegistrationForm.getFirstName());
		userDetails.setLastName(userRegistrationForm.getLastName());
		userDetails.setEmail(userRegistrationForm.getEmail());
		userDetails.setDateOfBirth(userRegistrationForm.getDateOfBirth());
		userDetails.setPhoneNumber(userRegistrationForm.getPhoneNumber());
		userDetails.setGender(userRegistrationForm.getGender());
		userDetails.setCity(userRegistrationForm.getCity());
		
		userAccount.setUserDetails(userDetails);
		user.setUserAccount(userAccount);
		
		userService.saveUser(user);
	}
	
	public UserService getUserService() {
		return userService;
	}
	
}

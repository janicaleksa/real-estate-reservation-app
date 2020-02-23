package com.janicaleksa.realestatereservationapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.janicaleksa.realestatereservationapp.constants.Constants;
import com.janicaleksa.realestatereservationapp.dto.UserRegistrationForm;
import com.janicaleksa.realestatereservationapp.facades.UserFacade;

@RestController
public class UserController {

	private final UserFacade userFacade;
	
	@Autowired
	public UserController(UserFacade userFacade) {
		this.userFacade = userFacade;
	}
	
	@PostMapping(value = Constants.API.User.REGISTRATION_URL)
	public void registerUser(@RequestBody UserRegistrationForm userRegistrationForm) {
		userFacade.registerUser(userRegistrationForm);
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}
}

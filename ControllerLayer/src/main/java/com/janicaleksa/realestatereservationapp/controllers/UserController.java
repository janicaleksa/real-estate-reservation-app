package com.janicaleksa.realestatereservationapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.janicaleksa.realestatereservationapp.constants.Constants;
import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.dto.UserDeactivateForm;
import com.janicaleksa.realestatereservationapp.dto.AuthenticationRequest;
import com.janicaleksa.realestatereservationapp.dto.JWTToken;
import com.janicaleksa.realestatereservationapp.dto.UserForm;
import com.janicaleksa.realestatereservationapp.facades.UserFacade;
import com.janicaleksa.realestatereservationapp.service.UserService;

@RestController
public class UserController {

	private final UserFacade userFacade;
	
	@Autowired
	public UserController(UserFacade userFacade) {
		this.userFacade = userFacade;
	}
	
	@PostMapping(value = Constants.API.User.REGISTRATION_URL)
	public void registerUser(@RequestBody UserForm userForm) {
		getUserFacade().registerUser(userForm);
	}
	
	@PostMapping(value = Constants.API.User.AUTHENTICATE_URL)
	public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
		return ResponseEntity.ok(getUserFacade().authenticateUser(authenticationRequest));
	}
	
	@PostMapping(value = Constants.API.User.LOGIN_URL)
	public UserDTO loginUser(@RequestBody AuthenticationRequest loginRequest) {
		return getUserFacade().loginUser(loginRequest);
	}
	
	@PutMapping(value = Constants.API.User.UPDATE_URL)
	public void updateUser(@RequestBody UserForm userForm) {
		getUserFacade().updateUser(userForm);
	}
	
	@DeleteMapping(value = Constants.API.User.DELETE_URL)
	public void deactivateUser(@RequestBody UserDeactivateForm userDeactivateForm) {
		getUserFacade().deactivateUser(userDeactivateForm);
	}
	
	public UserFacade getUserFacade() {
		return userFacade;
	}
}

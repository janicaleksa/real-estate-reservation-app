package com.janicaleksa.realestatereservationapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.janicaleksa.realestatereservationapp.constants.ControllerLayerConstants;
import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.dto.UserDeactivateFormDTO;
import com.janicaleksa.realestatereservationapp.exceptions.UserException;
import com.janicaleksa.realestatereservationapp.facades.UserFacade;

@RestController
public class UserController {

	private final UserFacade userFacade;
	
	@Autowired
	public UserController(UserFacade userFacade) {
		this.userFacade = userFacade;
	}
	
	@PostMapping(value = ControllerLayerConstants.API.User.REGISTRATION_URL)
	public void registerUser(@RequestBody UserDTO userDTO) {
		try {
			getUserFacade().registerUser(userDTO);
		} catch (UserException ue) {
			throw new UserException(ue.getMessage());
		}
	}
	
	@GetMapping(value = ControllerLayerConstants.API.User.AUTHENTICATE_URL)
	public ResponseEntity<?> authenticateUser(@PathVariable String username, @PathVariable String password) {
		try {
			return ResponseEntity.ok(getUserFacade().authenticateUser(username, password));
		} catch (UserException ue) {
			throw new UserException(ue.getMessage());
		}
	}
	
	@GetMapping(value = ControllerLayerConstants.API.User.LOGIN_URL)
	public ResponseEntity<?> loginUser(@PathVariable String username, @PathVariable String password) {
		try {
			return ResponseEntity.ok(getUserFacade().loginUser(username, password));
		} catch (UserException ue) {
			throw new UserException(ue.getMessage());
		}
	}
	
	@PutMapping(value = ControllerLayerConstants.API.User.UPDATE_URL)
	public void updateUser(@RequestBody UserDTO userForm) {
		getUserFacade().updateUser(userForm);
	}
	
	@DeleteMapping(value = ControllerLayerConstants.API.User.DELETE_URL)
	public void deactivateUser(@RequestBody UserDeactivateFormDTO userDeactivateForm) {
		getUserFacade().deactivateUser(userDeactivateForm);
	}
	
	public UserFacade getUserFacade() {
		return userFacade;
	}
}

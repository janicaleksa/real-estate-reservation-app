package com.janicaleksa.realestatereservationapp.facades.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.janicaleksa.realestatereservationapp.constants.ServiceLayerConstants;
import com.janicaleksa.realestatereservationapp.domain.JWTToken;
import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.dto.UserDeactivateForm;
import com.janicaleksa.realestatereservationapp.dto.AuthenticationRequest;
import com.janicaleksa.realestatereservationapp.dto.JWTTokenDTO;
import com.janicaleksa.realestatereservationapp.dto.UserForm;
import com.janicaleksa.realestatereservationapp.entities.UserDetails;
import com.janicaleksa.realestatereservationapp.facades.UserFacade;
import com.janicaleksa.realestatereservationapp.service.JWTService;
import com.janicaleksa.realestatereservationapp.service.UserService;

@Component
public class UserFacadeImpl implements UserFacade{

	private final UserService userService;
	private final JWTService jwtService;
	
	@Autowired
	public UserFacadeImpl(UserService userService, JWTService jwtService) {
		this.userService = userService;
		this.jwtService = jwtService;
	}
	
	public void registerUser(UserForm userForm) {
		User user = new User();
		
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		user.setRole(userForm.getRole());
		
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(userForm.getFirstName());
		userDetails.setLastName(userForm.getLastName());
		userDetails.setEmail(userForm.getEmail());
		userDetails.setDateOfBirth(userForm.getDateOfBirth());
		userDetails.setPhoneNumber(userForm.getPhoneNumber());
		userDetails.setGender(userForm.getGender());
		userDetails.setCity(userForm.getCity());
		
		user.setUserDetails(userDetails);
		
		getUserService().saveUser(user);
	}
	
	public JWTTokenDTO authenticateUser(AuthenticationRequest authenticationRequest) {
		User user = new User();
		user.setPassword(authenticationRequest.getPassword());
		user.setUsername(authenticationRequest.getUsername());
		
		getUserService().authenticateUser(user);
		User authenticatedUser = getUserService().loadUserByUsername(user);
		
		JWTToken jwtToken = new JWTToken(authenticatedUser, LocalDateTime.now(), LocalDateTime.now().plusHours(ServiceLayerConstants.JWTToken.EXPIRING_HOURS));
		String token = getJwtService().generateToken(jwtToken);
		
		return new JWTTokenDTO(token);
	}
	
	public UserDTO loginUser(AuthenticationRequest userLoginForm) {
		User user = new User();	
		user.setUsername(userLoginForm.getUsername());
		user.setPassword(userLoginForm.getPassword());
			
		User newUser = getUserService().loginUser(user);
	
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(newUser.getUsername());
		userDTO.setPassword(newUser.getPassword());
		userDTO.setRole(newUser.getRole());
		userDTO.setFirstName(newUser.getUserDetails().getFirstName());
		userDTO.setLastName(newUser.getUserDetails().getLastName());
		userDTO.setEmail(newUser.getUserDetails().getEmail());
		userDTO.setDateOfBirth(newUser.getUserDetails().getDateOfBirth());
		userDTO.setPhoneNumber(newUser.getUserDetails().getPhoneNumber());
		userDTO.setGender(newUser.getUserDetails().getGender());
		userDTO.setCity(newUser.getUserDetails().getCity());
		
		return userDTO;
	}
	
	public void updateUser(UserForm userForm) {
		User user = new User();
		
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		user.setRole(userForm.getRole());
		
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(userForm.getFirstName());
		userDetails.setLastName(userForm.getLastName());
		userDetails.setEmail(userForm.getEmail());
		userDetails.setDateOfBirth(userForm.getDateOfBirth());
		userDetails.setPhoneNumber(userForm.getPhoneNumber());
		userDetails.setGender(userForm.getGender());
		userDetails.setCity(userForm.getCity());
		
		user.setUserDetails(userDetails);
		
		getUserService().saveUser(user);
	}
	
	public void deactivateUser(UserDeactivateForm userDeactivateForm) {
		User user = new User();
		
		user.setUsername(userDeactivateForm.getUsername());
		getUserService().deleteUser(user);
	}

	private UserService getUserService() {
		return userService;
	}

	public JWTService getJwtService() {
		return jwtService;
	}

}

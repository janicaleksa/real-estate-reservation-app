package com.janicaleksa.realestatereservationapp.facades;

import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.dto.UserDeactivateForm;
import com.janicaleksa.realestatereservationapp.dto.AuthenticationRequest;
import com.janicaleksa.realestatereservationapp.dto.JWTTokenDTO;
import com.janicaleksa.realestatereservationapp.dto.UserForm;

public interface UserFacade {

	void registerUser(UserForm userForm);
	
	UserDTO loginUser(AuthenticationRequest userLoginForm);
	
	void updateUser(UserForm userForm);
	
	void deactivateUser(UserDeactivateForm userDeactivateForm);

	JWTTokenDTO authenticateUser(AuthenticationRequest authenticationRequest);
}

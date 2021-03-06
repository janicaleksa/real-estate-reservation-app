package com.janicaleksa.realestatereservationapp.facades;

import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.dto.UserDeactivateFormDTO;
import com.janicaleksa.realestatereservationapp.exceptions.UserException;
import com.janicaleksa.realestatereservationapp.dto.AuthenticationResponseDTO;

public interface UserFacade {

	void registerUser(UserDTO userForm) throws UserException;
	
	UserDTO loginUser(String username) throws UserException;
	
	void updateUser(UserDTO userForm);
	
	void deactivateUser(UserDeactivateFormDTO userDeactivateForm);

	AuthenticationResponseDTO authenticateUser(String username, String password) throws UserException;
}

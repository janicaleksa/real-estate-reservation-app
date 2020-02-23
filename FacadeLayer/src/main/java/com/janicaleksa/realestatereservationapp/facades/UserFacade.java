package com.janicaleksa.realestatereservationapp.facades;

import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.dto.UserLoginForm;
import com.janicaleksa.realestatereservationapp.dto.UserForm;

public interface UserFacade {

	void registerUser(UserForm userForm);
	
	UserDTO loginUser(UserLoginForm userLoginForm);
	
	void updateUser(UserForm userForm);
}

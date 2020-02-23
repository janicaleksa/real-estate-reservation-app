package com.janicaleksa.realestatereservationapp.facades;

import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.dto.UserLoginForm;
import com.janicaleksa.realestatereservationapp.dto.UserRegistrationForm;

public interface UserFacade {

	void registerUser(UserRegistrationForm userRegistrationForm);
	
	UserDTO loginUser(UserLoginForm userLoginForm);
}

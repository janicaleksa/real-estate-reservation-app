package com.janicaleksa.realestatereservationapp.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.janicaleksa.realestatereservationapp.constants.ServiceLayerConstants;
import com.janicaleksa.realestatereservationapp.domain.JWTToken;
import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.dto.UserDeactivateFormDTO;
import com.janicaleksa.realestatereservationapp.exceptions.UserException;
import com.janicaleksa.realestatereservationapp.dto.AuthenticationRequestDTO;
import com.janicaleksa.realestatereservationapp.dto.AuthenticationResponseDTO;
import com.janicaleksa.realestatereservationapp.facades.UserFacade;
import com.janicaleksa.realestatereservationapp.mappers.AuthenticationRequestMapper;
import com.janicaleksa.realestatereservationapp.mappers.UserMapper;
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
	
	public void registerUser(UserDTO userDTO) throws UserException {
		try {
			getUserService().saveUser(UserMapper.INSTANCE.userDTOToUser(userDTO));
		} catch (UserException ue) {
			throw ue;
		}
	}
	
	public AuthenticationResponseDTO authenticateUser(AuthenticationRequestDTO authenticationRequest) {
		User user = AuthenticationRequestMapper.INSTANCE.authenticationRequestDTOToUser(authenticationRequest);
		getUserService().authenticateUser(user);
		return new AuthenticationResponseDTO(getJwtService().generateToken(new JWTToken(getUserService().loadUserByUsername(user.getUsername()), 
				ServiceLayerConstants.JWTToken.CURRENT_DATE_TIME, ServiceLayerConstants.JWTToken.CURRENT_DATE_TIME.plusHours(ServiceLayerConstants.JWTToken.EXPIRING_HOURS))));
	}
	
	public UserDTO loginUser(AuthenticationRequestDTO authenticationRequestDTO) {
		User newUser = getUserService().loginUser(AuthenticationRequestMapper.INSTANCE.authenticationRequestDTOToUser(authenticationRequestDTO));
		return UserMapper.INSTANCE.userToUserDTO(newUser);
	}
	
	public void updateUser(UserDTO userDTO) {
		getUserService().updateUser(UserMapper.INSTANCE.userDTOToUser(userDTO));
	}
	
	public void deactivateUser(UserDeactivateFormDTO userDeactivateForm) {
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

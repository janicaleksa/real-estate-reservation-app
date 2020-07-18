package com.janicaleksa.realestatereservationapp.service;

import com.janicaleksa.realestatereservationapp.domain.JWTToken;
import com.janicaleksa.realestatereservationapp.domain.User;

public interface JWTService {

	String generateToken(JWTToken jwtToken);
	
	String extractUsername(String jwtTokenValue);
	
	Boolean validateToken(String jwtTokenValue, User user);
	
}

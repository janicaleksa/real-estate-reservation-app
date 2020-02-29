package com.janicaleksa.realestatereservationapp.service;

import com.janicaleksa.realestatereservationapp.domain.JWTToken;

public interface JWTService {

	String generateToken(JWTToken jwtToken);
}

package com.janicaleksa.realestatereservationapp.service.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.constants.ServiceLayerConstants;
import com.janicaleksa.realestatereservationapp.domain.JWTToken;
import com.janicaleksa.realestatereservationapp.service.JWTService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTServiceImpl implements JWTService {

	public String generateToken(JWTToken jwtToken) {
		return Jwts.builder().setSubject(jwtToken.getUser().getUsername())
							.setIssuedAt(Timestamp.valueOf(jwtToken.getDateIssued()))
							.setExpiration(Timestamp.valueOf(jwtToken.getDateExpired()))
							.signWith(SignatureAlgorithm.HS256, ServiceLayerConstants.JWTToken.SECRET_KEY)
							.compact();
	}

}

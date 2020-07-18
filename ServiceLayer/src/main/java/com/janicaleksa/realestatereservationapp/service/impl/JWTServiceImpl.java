 package com.janicaleksa.realestatereservationapp.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.constants.ServiceLayerConstants;
import com.janicaleksa.realestatereservationapp.domain.JWTToken;
import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.service.JWTService;

import io.jsonwebtoken.Claims;
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
	
	private <T> T exctractClaim(String jwtTokenValue, Function<Claims, T> claimsResolver) {
		return claimsResolver.apply(Jwts.parser().setSigningKey(ServiceLayerConstants.JWTToken.SECRET_KEY).parseClaimsJws(jwtTokenValue).getBody());
	}

	@Override
	public String extractUsername(String jwtTokenValue) {
		return exctractClaim(jwtTokenValue, Claims::getSubject);
	}
	
	private Date extractExpiration(String jwtTokenValue) {
		return exctractClaim(jwtTokenValue, Claims::getExpiration);
	}

	private Boolean isTokenExpired(String jwtTokenValue) {
		return extractExpiration(jwtTokenValue).before(ServiceLayerConstants.JWTToken.CURRENT_DATE);
	}

	@Override
	public Boolean validateToken(String jwtTokenValue, User user) {
		return Objects.isNull(user) || StringUtils.isEmpty(jwtTokenValue) ? false : (StringUtils.equals(extractUsername(jwtTokenValue), user.getUsername()) && !isTokenExpired(jwtTokenValue));
	}
	

}

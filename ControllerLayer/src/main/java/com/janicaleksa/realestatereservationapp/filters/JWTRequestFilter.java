package com.janicaleksa.realestatereservationapp.filters;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.janicaleksa.realestatereservationapp.constants.ControllerLayerConstants;
import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.service.JWTService;
import com.janicaleksa.realestatereservationapp.service.UserService;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {
	
	private final JWTService jwtService;
	private final UserService userService;
	
	@Autowired
	public JWTRequestFilter(JWTService jwtService, UserService userService) {
		this.jwtService = jwtService;
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwtTokenValue = request.getHeader(ControllerLayerConstants.JWTToken.AuthorizationHeader);	
			
			if(!StringUtils.isEmpty(jwtTokenValue)) {
				String username = getJwtService().extractUsername(jwtTokenValue);
				
				if(!StringUtils.isEmpty(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
					User user = getUserService().loadUserByUsername(username);
					
					if(getJwtService().validateToken(jwtTokenValue, user)) {
						UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
						usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		filterChain.doFilter(request, response);
	}

	private JWTService getJwtService() {
		return jwtService;
	}

	private UserService getUserService() {
		return userService;
	}

}

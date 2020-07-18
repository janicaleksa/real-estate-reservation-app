package com.janicaleksa.realestatereservationapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.janicaleksa.realestatereservationapp.constants.ControllerLayerConstants;
import com.janicaleksa.realestatereservationapp.filters.JWTRequestFilter;
import com.janicaleksa.realestatereservationapp.service.UserSecurityService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserSecurityService userSecurityService;
	private final JWTRequestFilter jwtRequestFilter;

	@Autowired
	public SecurityConfig(UserSecurityService userSecurityService, JWTRequestFilter jwtRequestFilter) {
		this.userSecurityService = userSecurityService;
		this.jwtRequestFilter = jwtRequestFilter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(getUserSecurityService());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests().antMatchers(ControllerLayerConstants.API.User.AUTHENTICATE_URL).permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(getJwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);
	} 
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	public UserSecurityService getUserSecurityService() {
		return userSecurityService;
	}

	private JWTRequestFilter getJwtRequestFilter() {
		return jwtRequestFilter;
	}
}

package com.janicaleksa.realestatereservationapp.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserSecurityService extends UserDetailsService, AuthenticationManager {

}

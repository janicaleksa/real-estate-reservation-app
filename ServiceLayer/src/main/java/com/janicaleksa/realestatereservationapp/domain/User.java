package com.janicaleksa.realestatereservationapp.domain;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.janicaleksa.realestatereservationapp.entities.UserAccount;

public class User extends UserAccount implements UserDetails {


	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(super.getRole().toString()));
				
	}

	public String getPassword() {
		return super.getPassword();
		
	}

	public String getUsername() {
		return super.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
	
}

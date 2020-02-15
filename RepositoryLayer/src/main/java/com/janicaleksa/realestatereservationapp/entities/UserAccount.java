package com.janicaleksa.realestatereservationapp.entities;

import lombok.Data;

@Data
public class UserAccount {
	
	private String username;
	private String password;
	private UserDetails userDetails;
	private Role role;
}

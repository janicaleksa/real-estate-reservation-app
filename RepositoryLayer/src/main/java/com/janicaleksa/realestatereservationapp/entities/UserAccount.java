package com.janicaleksa.realestatereservationapp.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data 
public class UserAccount {
	
	@Id
	private String username;
	@Column(name = "user_password")
	private String password;
	@Embedded
	private UserDetails userDetails;
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	private Role role;
}

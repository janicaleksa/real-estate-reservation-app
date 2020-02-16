package com.janicaleksa.realestatereservationapp.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
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
	@OneToMany(mappedBy = "owner")
	private Collection<Advertisement> collectionAdvertisements;
}

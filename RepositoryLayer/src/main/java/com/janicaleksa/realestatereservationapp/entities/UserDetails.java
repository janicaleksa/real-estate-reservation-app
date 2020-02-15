package com.janicaleksa.realestatereservationapp.entities;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class UserDetails {

	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dateOfBirth;
	private String phoneNumber;
	private Gender gender;
	private City city;
}

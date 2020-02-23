package com.janicaleksa.realestatereservationapp.dto;

import java.time.LocalDate;

import com.janicaleksa.realestatereservationapp.entities.City;
import com.janicaleksa.realestatereservationapp.entities.Gender;
import com.janicaleksa.realestatereservationapp.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
public class UserForm {

	private String username;
	private String password;
	private Role role;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dateOfBirth;
	private String phoneNumber;
	private Gender gender;
	private City city;
}

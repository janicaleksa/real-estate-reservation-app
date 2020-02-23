package com.janicaleksa.realestatereservationapp.domain;

import com.janicaleksa.realestatereservationapp.entities.UserAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	private UserAccount userAccount;
	
}

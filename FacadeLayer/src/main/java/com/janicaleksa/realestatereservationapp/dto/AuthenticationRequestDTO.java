package com.janicaleksa.realestatereservationapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
public class AuthenticationRequestDTO {

	private String username;
	private String password;
	
}

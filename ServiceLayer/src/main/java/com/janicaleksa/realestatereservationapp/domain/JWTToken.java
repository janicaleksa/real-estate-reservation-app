package com.janicaleksa.realestatereservationapp.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
public class JWTToken {

	private User user;
	private LocalDateTime dateIssued;
	private LocalDateTime dateExpired;
}

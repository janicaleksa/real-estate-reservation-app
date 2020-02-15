package com.janicaleksa.realestatereservationapp.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Advertisement {

	private Long code;
	private LocalDate date;
	private String description;
	private BigDecimal price;
	private RealEstate realEstate;
	private UserAccount owner;
	
}

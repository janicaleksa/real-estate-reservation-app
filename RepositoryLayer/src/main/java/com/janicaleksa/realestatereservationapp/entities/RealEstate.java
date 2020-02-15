package com.janicaleksa.realestatereservationapp.entities;

import lombok.Data;

@Data
public class RealEstate {

	private String name;
	private String address;
	private Integer quadrature;
	private Integer capacity;
	private Category category;
}

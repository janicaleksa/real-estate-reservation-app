package com.janicaleksa.realestatereservationapp.entities;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Embeddable
@Data
public class RealEstate {

	private String name;
	private String address;
	private Integer quadrature;
	private Integer capacity;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Enumerated(EnumType.STRING)
	private City city;
}

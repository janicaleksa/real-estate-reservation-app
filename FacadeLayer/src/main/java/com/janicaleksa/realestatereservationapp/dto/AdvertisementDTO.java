package com.janicaleksa.realestatereservationapp.dto;

import java.math.BigDecimal;

import com.janicaleksa.realestatereservationapp.entities.Category;
import com.janicaleksa.realestatereservationapp.entities.City;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdvertisementDTO {

	private Long code;
	private String description;
	private BigDecimal price;
	private String name;
	private String address;
	private Integer quadrature;
	private Integer capacity;
	private Category category;
	private City city;
	private String username;
}

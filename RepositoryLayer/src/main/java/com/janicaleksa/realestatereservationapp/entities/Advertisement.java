package com.janicaleksa.realestatereservationapp.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Advertisement {

	@Id
	@Column(columnDefinition = "bigserial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private LocalDate date;
	@Column(columnDefinition = "text")
	private String description;
	private BigDecimal price;
	@Embedded
	private RealEstate realEstate;
}

package com.janicaleksa.realestatereservationapp.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Reservation {

	private Long id;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private BigDecimal totalPrice;
	private Advertisement advertisement;
	private UserAccount renter;
}

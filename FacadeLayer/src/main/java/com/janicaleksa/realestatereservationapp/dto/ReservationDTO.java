package com.janicaleksa.realestatereservationapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDTO {

	private Long id;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private BigDecimal totalPrice;
	private Long advertisementCode;
	private String renterUsername;
}

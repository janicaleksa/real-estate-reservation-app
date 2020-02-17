package com.janicaleksa.realestatereservationapp.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "dateFrom"),
		@UniqueConstraint(columnNames = "dateTo")
})
@Data
public class Reservation {

	@Id
	@Column(columnDefinition = "bigserial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private BigDecimal totalPrice;
	@ManyToOne
	@JoinColumn(name = "advertisement", foreignKey = @ForeignKey(name = "advertisement_fk"))
	private Advertisement advertisement;
	@ManyToOne
	@JoinColumn(name = "renter", foreignKey = @ForeignKey(name = "user_account_fk"))
	private UserAccount renter;
}

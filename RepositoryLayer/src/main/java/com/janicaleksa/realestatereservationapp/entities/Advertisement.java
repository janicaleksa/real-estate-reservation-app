package com.janicaleksa.realestatereservationapp.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Advertisement {

	@Id
	@Column(columnDefinition = "bigserial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@Column(name = "advertisement_date")
	private LocalDate date;
	@Column(columnDefinition = "text")
	private String description;
	private BigDecimal price;
	@Embedded
	private RealEstate realEstate;
	@ManyToOne
	@JoinColumn(name = "owner_username", foreignKey = @ForeignKey(name = "user_account_fk"))
	private UserAccount owner;
}

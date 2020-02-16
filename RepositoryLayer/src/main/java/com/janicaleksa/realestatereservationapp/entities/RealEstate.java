package com.janicaleksa.realestatereservationapp.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Embeddable
@Data
public class RealEstate {

	@Column(name = "real_estate_name")
	private String name;
	private String address;
	private Integer quadrature;
	private Integer capacity;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Enumerated(EnumType.STRING)
	private City city;
	@ManyToOne
	@JoinColumn(name = "owner_username", foreignKey = @ForeignKey(name = "user_account_fk"))
	private UserAccount owner;
	@OneToMany(mappedBy = "advertisement")
	private Collection<Reservation> collectionReservations;
}

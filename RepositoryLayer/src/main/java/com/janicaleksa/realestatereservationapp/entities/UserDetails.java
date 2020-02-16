package com.janicaleksa.realestatereservationapp.entities;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import lombok.Data;

@Embeddable
@Data
public class UserDetails {

	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	private String email;
	private LocalDate dateOfBirth;
	private String phoneNumber;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private City city;
	@OneToMany(mappedBy = "realEstate.owner")
	private Collection<Advertisement> collectionAdvertisements;
	@OneToMany(mappedBy = "renter")
	private Collection<Reservation> collectionReservations;
}

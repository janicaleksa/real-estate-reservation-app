package com.janicaleksa.realestatereservationapp.service;

import java.util.Collection;

import com.janicaleksa.realestatereservationapp.entities.Reservation;

public interface ReservationService {

	Reservation findReservationById(Long id);

	Collection<Reservation> findAllReservations();

	void saveReservation(Reservation reservation);

	void updateReservation(Reservation reservation);

	void deleteReservationById(Long id);
}

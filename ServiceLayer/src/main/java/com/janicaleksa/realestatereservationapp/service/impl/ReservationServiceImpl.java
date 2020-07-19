package com.janicaleksa.realestatereservationapp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.entities.Reservation;
import com.janicaleksa.realestatereservationapp.repositories.ReservationRepository;
import com.janicaleksa.realestatereservationapp.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@Override
	public Reservation findReservationById(Long id) {
		return getReservationRepository().findById(id).get();
	}

	@Override
	public Collection<Reservation> findAllReservations() {
		return getReservationRepository().findAll();
	}

	@Override
	public void saveReservation(Reservation reservation) {
		getReservationRepository().save(reservation);
	}

	@Override
	public void updateReservation(Reservation reservation) {
		getReservationRepository().save(reservation);
	}

	@Override
	public void deleteReservationById(Long id) {
		getReservationRepository().deleteById(id);
	}

	private ReservationRepository getReservationRepository() {
		return reservationRepository;
	}

}

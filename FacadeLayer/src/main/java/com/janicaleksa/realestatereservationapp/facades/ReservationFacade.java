package com.janicaleksa.realestatereservationapp.facades;

import java.util.Collection;

import com.janicaleksa.realestatereservationapp.dto.ReservationDTO;

public interface ReservationFacade {

	ReservationDTO findReservationById(Long id);

	Collection<ReservationDTO> findAllReservations();

	void saveReservation(ReservationDTO reservationDTO);

	void updateReservation(ReservationDTO reservationDTO);

	void deleteReservationById(Long id);

}

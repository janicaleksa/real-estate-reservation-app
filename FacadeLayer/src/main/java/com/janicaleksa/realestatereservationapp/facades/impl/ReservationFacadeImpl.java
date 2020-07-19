package com.janicaleksa.realestatereservationapp.facades.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.janicaleksa.realestatereservationapp.dto.ReservationDTO;
import com.janicaleksa.realestatereservationapp.facades.ReservationFacade;
import com.janicaleksa.realestatereservationapp.mappers.ReservationMapper;
import com.janicaleksa.realestatereservationapp.service.ReservationService;

@Component
public class ReservationFacadeImpl implements ReservationFacade {

	private final ReservationService reservationService;
	
	@Autowired
	public ReservationFacadeImpl(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@Override
	public ReservationDTO findReservationById(Long id) {
		return ReservationMapper.INSTANCE.reservationToReservationDTO(getReservationService().findReservationById(id));
	}

	@Override
	public Collection<ReservationDTO> findAllReservations() {
		return getReservationService().findAllReservations().stream()
				.map(reservation -> ReservationMapper.INSTANCE.reservationToReservationDTO(reservation))
				.collect(Collectors.toList());
	}

	@Override
	public void saveReservation(ReservationDTO reservationDTO) {
		getReservationService().saveReservation(ReservationMapper.INSTANCE.reservationDTOToReservation(reservationDTO));
	}

	@Override
	public void updateReservation(ReservationDTO reservationDTO) {
		getReservationService().updateReservation(ReservationMapper.INSTANCE.reservationDTOToReservation(reservationDTO));
	}

	@Override
	public void deleteReservationById(Long id) {
		getReservationService().deleteReservationById(id);
	}

	private ReservationService getReservationService() {
		return reservationService;
	}

}

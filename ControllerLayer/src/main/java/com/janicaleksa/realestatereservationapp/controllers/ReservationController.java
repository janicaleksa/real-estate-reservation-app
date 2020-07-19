package com.janicaleksa.realestatereservationapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.janicaleksa.realestatereservationapp.constants.ControllerLayerConstants;
import com.janicaleksa.realestatereservationapp.dto.ReservationDTO;
import com.janicaleksa.realestatereservationapp.facades.ReservationFacade;

@RestController
public class ReservationController {

	private final ReservationFacade reservationFacade;
	
	@Autowired
	public ReservationController(ReservationFacade reservationFacade) {
		this.reservationFacade = reservationFacade;
	}
	
	@GetMapping(value = ControllerLayerConstants.API.Reservation.GET_SINGLE)
	public ResponseEntity<?> getReservationByCode(@PathVariable Long id) {
		return ResponseEntity.ok(getReservationFacade().findReservationById(id));
	}
	
	@GetMapping(value = ControllerLayerConstants.API.Reservation.GET_ALL)
	public ResponseEntity<?> getAllReservations() {
		return ResponseEntity.ok(getReservationFacade().findAllReservations());
	}
	
	@PostMapping(value = ControllerLayerConstants.API.Reservation.CREATE_URL)
	public void createReservation(@RequestBody ReservationDTO reservationDTO) {
		getReservationFacade().saveReservation(reservationDTO);
	}
	
	@PutMapping(value = ControllerLayerConstants.API.Reservation.UPDATE_URL)
	public void updateReservation(@RequestBody ReservationDTO reservationDTO) {
		getReservationFacade().updateReservation(reservationDTO);
	}
	
	@DeleteMapping(value = ControllerLayerConstants.API.Reservation.DELETE_URL)
	public void deleteReservation(@PathVariable Long id) {
		getReservationFacade().deleteReservationById(id);
	}

	private ReservationFacade getReservationFacade() {
		return reservationFacade;
	}

}

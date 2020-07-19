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
import com.janicaleksa.realestatereservationapp.dto.AdvertisementDTO;
import com.janicaleksa.realestatereservationapp.facades.AdvertisementFacade;

@RestController
public class AdvertisementController {

	private final AdvertisementFacade advertisementFacade;
	
	@Autowired
	public AdvertisementController(AdvertisementFacade advertisementFacade) {
		this.advertisementFacade = advertisementFacade;
	}
	
	@GetMapping(value = ControllerLayerConstants.API.Advertisement.GET_SINGLE)
	public ResponseEntity<?> getAdvertisementByCode(@PathVariable Long code) {
		return ResponseEntity.ok(getAdvertisementFacade().findAdvertisementByCode(code));
	}
	
	@GetMapping(value = ControllerLayerConstants.API.Advertisement.GET_ALL)
	public ResponseEntity<?> getAllAdvertisements() {
		return ResponseEntity.ok(getAdvertisementFacade().findAllAdvertisement());
	}
	
	@PostMapping(value = ControllerLayerConstants.API.Advertisement.CREATE_URL)
	public void createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {
		getAdvertisementFacade().saveAdvertisement(advertisementDTO);
	}
	
	@PutMapping(value = ControllerLayerConstants.API.Advertisement.UPDATE_URL)
	public void updateAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {
		getAdvertisementFacade().updateAdvertisement(advertisementDTO);
	}
	
	@DeleteMapping(value = ControllerLayerConstants.API.Advertisement.DELETE_URL)
	public void deleteAdvertisement(@PathVariable Long code) {
		getAdvertisementFacade().deleteAdvertisementByCode(code);
	}

	private AdvertisementFacade getAdvertisementFacade() {
		return advertisementFacade;
	}
}

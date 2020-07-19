package com.janicaleksa.realestatereservationapp.facades;

import java.util.Collection;

import com.janicaleksa.realestatereservationapp.dto.AdvertisementDTO;

public interface AdvertisementFacade {

	AdvertisementDTO findAdvertisementByCode(Long code);
	
	Collection<AdvertisementDTO> findAllAdvertisement();
	
	void saveAdvertisement(AdvertisementDTO advertisementDTO);
	
	void updateAdvertisement(AdvertisementDTO advertisementDTO);
	
	void deleteAdvertisementByCode(Long code);
	
}

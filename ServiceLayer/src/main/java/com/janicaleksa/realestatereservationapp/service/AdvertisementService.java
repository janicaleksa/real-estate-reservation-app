package com.janicaleksa.realestatereservationapp.service;

import java.util.Collection;

import com.janicaleksa.realestatereservationapp.entities.Advertisement;

public interface AdvertisementService {

	Advertisement findAdvertisementByCode(Long code);

	Collection<Advertisement> findAll();

	void saveAdvertisement(Advertisement advertisement);

	void updateAdvertisement(Advertisement advertisement);

	void deleteAdvertisementByCode(Long code);

}

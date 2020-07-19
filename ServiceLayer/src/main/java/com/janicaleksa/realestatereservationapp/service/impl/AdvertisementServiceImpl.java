package com.janicaleksa.realestatereservationapp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.entities.Advertisement;
import com.janicaleksa.realestatereservationapp.repositories.AdvertisementRepository;
import com.janicaleksa.realestatereservationapp.service.AdvertisementService;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
	
	private final AdvertisementRepository advertisementRepository;
	
	@Autowired
	public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
		this.advertisementRepository = advertisementRepository;
	}

	@Override
	public Advertisement findByCode(Long code) {
		return getAdvertisementRepository().findByCode(code).get();
	}

	@Override
	public Collection<Advertisement> findAll() {
		return getAdvertisementRepository().findAll();
	}

	@Override
	public void saveAdvertisement(Advertisement advertisement) {
		getAdvertisementRepository().save(advertisement);
	}

	@Override
	public void updateAdvertisement(Advertisement advertisement) {
		getAdvertisementRepository().save(advertisement);
		
	}

	@Override
	public void deleteAdvertisement(Long code) {
		getAdvertisementRepository().deleteById(code);
	}

	private AdvertisementRepository getAdvertisementRepository() {
		return advertisementRepository;
	}

}

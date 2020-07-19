package com.janicaleksa.realestatereservationapp.facades.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.janicaleksa.realestatereservationapp.dto.AdvertisementDTO;
import com.janicaleksa.realestatereservationapp.facades.AdvertisementFacade;
import com.janicaleksa.realestatereservationapp.mappers.AdvertisementMapper;
import com.janicaleksa.realestatereservationapp.service.AdvertisementService;

@Component
public class AdvertisementFacadeImpl implements AdvertisementFacade {
	
	private final AdvertisementService advertisementService;
	
	@Autowired
	public AdvertisementFacadeImpl(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}

	@Override
	public AdvertisementDTO findAdvertisementByCode(Long code) {
		return AdvertisementMapper.INSTANCE.advertisementToAdvertisementDTO(getAdvertisementService().findByCode(code));
	}

	@Override
	public Collection<AdvertisementDTO> findAllAdvertisement() {
		return getAdvertisementService().findAll().stream()
				.map(advertisement -> AdvertisementMapper.INSTANCE.advertisementToAdvertisementDTO(advertisement))
				.collect(Collectors.toList());
	}
	
	@Override
	public void saveAdvertisement(AdvertisementDTO advertisementDTO) {
		getAdvertisementService().saveAdvertisement(AdvertisementMapper.INSTANCE.advertisementDTOToAdvertisement(advertisementDTO));
	}

	@Override
	public void updateAdvertisement(AdvertisementDTO advertisementDTO) {
		getAdvertisementService().updateAdvertisement(AdvertisementMapper.INSTANCE.advertisementDTOToAdvertisement(advertisementDTO));
	}

	@Override
	public void deleteAdvertisementByCode(Long code) {
		getAdvertisementService().deleteAdvertisement(code);
	}

	private AdvertisementService getAdvertisementService() {
		return advertisementService;
	}

}

package com.janicaleksa.realestatereservationapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.janicaleksa.realestatereservationapp.entities.Advertisement;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long>{

	Optional<Advertisement> findByCode(Long code);
	
}

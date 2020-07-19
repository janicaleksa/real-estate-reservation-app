package com.janicaleksa.realestatereservationapp.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.janicaleksa.realestatereservationapp.dto.ReservationDTO;
import com.janicaleksa.realestatereservationapp.entities.Reservation;

@Mapper
public interface ReservationMapper {

	ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);
	
	@Mappings({
		@Mapping(target = "advertisementCode", source = "advertisement.code"),
		@Mapping(target = "renterUsername", source = "renter.username")
	})
	ReservationDTO reservationToReservationDTO(Reservation reservation);
	
	@InheritInverseConfiguration
	Reservation reservationDTOToReservation(ReservationDTO reservationDTO);
}

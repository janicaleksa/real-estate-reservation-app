package com.janicaleksa.realestatereservationapp.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.janicaleksa.realestatereservationapp.dto.AdvertisementDTO;
import com.janicaleksa.realestatereservationapp.entities.Advertisement;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface AdvertisementMapper {

	AdvertisementMapper INSTANCE = Mappers.getMapper(AdvertisementMapper.class);
	
	@Mappings({
		@Mapping(target= "name", source = "realEstate.name"),
		@Mapping(target= "address", source = "realEstate.address"),
		@Mapping(target= "quadrature", source = "realEstate.quadrature"),
		@Mapping(target= "capacity", source = "realEstate.capacity"),
		@Mapping(target= "category", source = "realEstate.category"),
		@Mapping(target= "city", source = "realEstate.city"),
		@Mapping(target= "username", source = "realEstate.owner.username")
	})
	AdvertisementDTO advertisementToAdvertisementDTO(Advertisement advertisement);
	
	@InheritInverseConfiguration
	@Mapping(target = "date", expression = "java(java.time.LocalDate.now())")
	Advertisement advertisementDTOToAdvertisement(AdvertisementDTO advertisement);
}

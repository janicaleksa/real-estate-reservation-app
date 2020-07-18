package com.janicaleksa.realestatereservationapp.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.dto.AuthenticationRequestDTO;

@Mapper
public interface AuthenticationRequestMapper {
	
	AuthenticationRequestMapper INSTANCE = Mappers.getMapper(AuthenticationRequestMapper.class);

	AuthenticationRequestDTO userToAuthenticationRequestDTO(User user);
	
	@InheritInverseConfiguration
	User authenticationRequestDTOToUser(AuthenticationRequestDTO authenticationRequestDTO);
}

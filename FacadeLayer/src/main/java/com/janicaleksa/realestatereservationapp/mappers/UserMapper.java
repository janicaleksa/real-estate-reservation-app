package com.janicaleksa.realestatereservationapp.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.entities.UserDetails;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDTO userToUserDTO(User user);
	
	@InheritInverseConfiguration
	User userDTOToUser(UserDTO userDTO);
	
	@Mappings({
		@Mapping(source = "firstName", target = "firstName"),
		@Mapping(source = "lastName", target = "lastName"),
		@Mapping(source = "email", target = "email"),
		@Mapping(source = "dateOfBirth", target = "dateOfBirth"),
		@Mapping(source = "phoneNumber", target = "phoneNumber"),
		@Mapping(source = "gender", target = "gender"),
		@Mapping(source = "city", target = "city")
	})
	UserDTO userDetailsToUserDTO(UserDetails userDetails);
	
	@InheritInverseConfiguration
	UserDetails userDetailsToUserDTO(UserDTO userDetails);
}

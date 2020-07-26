package com.janicaleksa.realestatereservationapp.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;

@Mapper
public interface UserAccountMapper {

	UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);
	
	User userAccountToUser(UserAccount userAccount);
	
	@InheritInverseConfiguration
	UserAccount userToUserAccount(User user);
}

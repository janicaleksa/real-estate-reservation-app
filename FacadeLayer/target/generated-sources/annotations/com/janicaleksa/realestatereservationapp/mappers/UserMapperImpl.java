package com.janicaleksa.realestatereservationapp.mappers;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.dto.UserDTO;
import com.janicaleksa.realestatereservationapp.entities.UserDetails;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-18T18:32:53+0200",
    comments = "version: 1.4.0.Beta2, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 1.8.0_212 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setPassword( user.getPassword() );
        userDTO.setRole( user.getRole() );
        userDTO.setUsername( user.getUsername() );

        return userDTO;
    }

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( userDTO.getPassword() );
        user.setRole( userDTO.getRole() );
        user.setUsername( userDTO.getUsername() );

        return user;
    }

    @Override
    public UserDTO userDetailsToUserDTO(UserDetails userDetails) {
        if ( userDetails == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName( userDetails.getFirstName() );
        userDTO.setLastName( userDetails.getLastName() );
        userDTO.setEmail( userDetails.getEmail() );
        userDTO.setDateOfBirth( userDetails.getDateOfBirth() );
        userDTO.setPhoneNumber( userDetails.getPhoneNumber() );
        userDTO.setGender( userDetails.getGender() );
        userDTO.setCity( userDetails.getCity() );

        return userDTO;
    }

    @Override
    public UserDetails userDetailsToUserDTO(UserDTO userDetails) {
        if ( userDetails == null ) {
            return null;
        }

        UserDetails userDetails1 = new UserDetails();

        userDetails1.setFirstName( userDetails.getFirstName() );
        userDetails1.setLastName( userDetails.getLastName() );
        userDetails1.setEmail( userDetails.getEmail() );
        userDetails1.setDateOfBirth( userDetails.getDateOfBirth() );
        userDetails1.setPhoneNumber( userDetails.getPhoneNumber() );
        userDetails1.setGender( userDetails.getGender() );
        userDetails1.setCity( userDetails.getCity() );

        return userDetails1;
    }
}

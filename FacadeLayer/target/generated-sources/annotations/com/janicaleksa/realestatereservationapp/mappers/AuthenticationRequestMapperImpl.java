package com.janicaleksa.realestatereservationapp.mappers;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.dto.AuthenticationRequestDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-18T21:07:19+0200",
    comments = "version: 1.4.0.Beta2, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 1.8.0_212 (Oracle Corporation)"
)
public class AuthenticationRequestMapperImpl implements AuthenticationRequestMapper {

    @Override
    public AuthenticationRequestDTO userToAuthenticationRequestDTO(User user) {
        if ( user == null ) {
            return null;
        }

        AuthenticationRequestDTO authenticationRequestDTO = new AuthenticationRequestDTO();

        authenticationRequestDTO.setPassword( user.getPassword() );
        authenticationRequestDTO.setUsername( user.getUsername() );

        return authenticationRequestDTO;
    }

    @Override
    public User authenticationRequestDTOToUser(AuthenticationRequestDTO authenticationRequestDTO) {
        if ( authenticationRequestDTO == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( authenticationRequestDTO.getPassword() );
        user.setUsername( authenticationRequestDTO.getUsername() );

        return user;
    }
}

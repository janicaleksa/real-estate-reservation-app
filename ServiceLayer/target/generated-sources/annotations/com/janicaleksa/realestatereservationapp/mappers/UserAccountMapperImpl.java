package com.janicaleksa.realestatereservationapp.mappers;

import com.janicaleksa.realestatereservationapp.domain.User;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-18T21:07:14+0200",
    comments = "version: 1.4.0.Beta2, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 1.8.0_212 (Oracle Corporation)"
)
public class UserAccountMapperImpl implements UserAccountMapper {

    @Override
    public User userAccountToUser(UserAccount userAccount) {
        if ( userAccount == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( userAccount.getPassword() );
        user.setRole( userAccount.getRole() );
        user.setUserDetails( userAccount.getUserDetails() );
        user.setUsername( userAccount.getUsername() );

        return user;
    }
}

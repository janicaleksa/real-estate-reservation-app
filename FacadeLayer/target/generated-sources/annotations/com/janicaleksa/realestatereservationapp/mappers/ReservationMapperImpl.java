package com.janicaleksa.realestatereservationapp.mappers;

import com.janicaleksa.realestatereservationapp.dto.ReservationDTO;
import com.janicaleksa.realestatereservationapp.entities.Advertisement;
import com.janicaleksa.realestatereservationapp.entities.Reservation;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-26T14:20:04+0200",
    comments = "version: 1.4.0.Beta2, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 1.8.0_212 (Oracle Corporation)"
)
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationDTO reservationToReservationDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setAdvertisementCode( reservationAdvertisementCode( reservation ) );
        reservationDTO.setRenterUsername( reservationRenterUsername( reservation ) );
        reservationDTO.setDateFrom( reservation.getDateFrom() );
        reservationDTO.setDateTo( reservation.getDateTo() );
        reservationDTO.setId( reservation.getId() );
        reservationDTO.setTotalPrice( reservation.getTotalPrice() );

        return reservationDTO;
    }

    @Override
    public Reservation reservationDTOToReservation(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setAdvertisement( reservationDTOToAdvertisement( reservationDTO ) );
        reservation.setRenter( reservationDTOToUserAccount( reservationDTO ) );
        reservation.setDateFrom( reservationDTO.getDateFrom() );
        reservation.setDateTo( reservationDTO.getDateTo() );
        reservation.setId( reservationDTO.getId() );
        reservation.setTotalPrice( reservationDTO.getTotalPrice() );

        return reservation;
    }

    private Long reservationAdvertisementCode(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        Advertisement advertisement = reservation.getAdvertisement();
        if ( advertisement == null ) {
            return null;
        }
        Long code = advertisement.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String reservationRenterUsername(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        UserAccount renter = reservation.getRenter();
        if ( renter == null ) {
            return null;
        }
        String username = renter.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    protected Advertisement reservationDTOToAdvertisement(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        Advertisement advertisement = new Advertisement();

        advertisement.setCode( reservationDTO.getAdvertisementCode() );

        return advertisement;
    }

    protected UserAccount reservationDTOToUserAccount(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        UserAccount userAccount = new UserAccount();

        userAccount.setUsername( reservationDTO.getRenterUsername() );

        return userAccount;
    }
}

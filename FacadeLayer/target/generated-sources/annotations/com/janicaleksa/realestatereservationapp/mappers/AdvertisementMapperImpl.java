package com.janicaleksa.realestatereservationapp.mappers;

import com.janicaleksa.realestatereservationapp.dto.AdvertisementDTO;
import com.janicaleksa.realestatereservationapp.entities.Advertisement;
import com.janicaleksa.realestatereservationapp.entities.Category;
import com.janicaleksa.realestatereservationapp.entities.City;
import com.janicaleksa.realestatereservationapp.entities.RealEstate;
import com.janicaleksa.realestatereservationapp.entities.UserAccount;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-29T19:17:14+0200",
    comments = "version: 1.4.0.Beta2, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 1.8.0_212 (Oracle Corporation)"
)
public class AdvertisementMapperImpl implements AdvertisementMapper {

    @Override
    public AdvertisementDTO advertisementToAdvertisementDTO(Advertisement advertisement) {
        if ( advertisement == null ) {
            return null;
        }

        AdvertisementDTO advertisementDTO = new AdvertisementDTO();

        advertisementDTO.setName( advertisementRealEstateName( advertisement ) );
        advertisementDTO.setAddress( advertisementRealEstateAddress( advertisement ) );
        advertisementDTO.setQuadrature( advertisementRealEstateQuadrature( advertisement ) );
        advertisementDTO.setCapacity( advertisementRealEstateCapacity( advertisement ) );
        advertisementDTO.setCategory( advertisementRealEstateCategory( advertisement ) );
        advertisementDTO.setCity( advertisementRealEstateCity( advertisement ) );
        advertisementDTO.setUsername( advertisementRealEstateOwnerUsername( advertisement ) );
        advertisementDTO.setCode( advertisement.getCode() );
        advertisementDTO.setDescription( advertisement.getDescription() );
        advertisementDTO.setPrice( advertisement.getPrice() );

        return advertisementDTO;
    }

    @Override
    public Advertisement advertisementDTOToAdvertisement(AdvertisementDTO advertisement) {
        if ( advertisement == null ) {
            return null;
        }

        Advertisement advertisement1 = new Advertisement();

        advertisement1.setRealEstate( advertisementDTOToRealEstate( advertisement ) );
        advertisement1.setCode( advertisement.getCode() );
        advertisement1.setDescription( advertisement.getDescription() );
        advertisement1.setPrice( advertisement.getPrice() );

        advertisement1.setDate( java.time.LocalDate.now() );

        return advertisement1;
    }

    private String advertisementRealEstateName(Advertisement advertisement) {
        if ( advertisement == null ) {
            return null;
        }
        RealEstate realEstate = advertisement.getRealEstate();
        if ( realEstate == null ) {
            return null;
        }
        String name = realEstate.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String advertisementRealEstateAddress(Advertisement advertisement) {
        if ( advertisement == null ) {
            return null;
        }
        RealEstate realEstate = advertisement.getRealEstate();
        if ( realEstate == null ) {
            return null;
        }
        String address = realEstate.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private Integer advertisementRealEstateQuadrature(Advertisement advertisement) {
        if ( advertisement == null ) {
            return null;
        }
        RealEstate realEstate = advertisement.getRealEstate();
        if ( realEstate == null ) {
            return null;
        }
        Integer quadrature = realEstate.getQuadrature();
        if ( quadrature == null ) {
            return null;
        }
        return quadrature;
    }

    private Integer advertisementRealEstateCapacity(Advertisement advertisement) {
        if ( advertisement == null ) {
            return null;
        }
        RealEstate realEstate = advertisement.getRealEstate();
        if ( realEstate == null ) {
            return null;
        }
        Integer capacity = realEstate.getCapacity();
        if ( capacity == null ) {
            return null;
        }
        return capacity;
    }

    private Category advertisementRealEstateCategory(Advertisement advertisement) {
        if ( advertisement == null ) {
            return null;
        }
        RealEstate realEstate = advertisement.getRealEstate();
        if ( realEstate == null ) {
            return null;
        }
        Category category = realEstate.getCategory();
        if ( category == null ) {
            return null;
        }
        return category;
    }

    private City advertisementRealEstateCity(Advertisement advertisement) {
        if ( advertisement == null ) {
            return null;
        }
        RealEstate realEstate = advertisement.getRealEstate();
        if ( realEstate == null ) {
            return null;
        }
        City city = realEstate.getCity();
        if ( city == null ) {
            return null;
        }
        return city;
    }

    private String advertisementRealEstateOwnerUsername(Advertisement advertisement) {
        if ( advertisement == null ) {
            return null;
        }
        RealEstate realEstate = advertisement.getRealEstate();
        if ( realEstate == null ) {
            return null;
        }
        UserAccount owner = realEstate.getOwner();
        if ( owner == null ) {
            return null;
        }
        String username = owner.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    protected UserAccount advertisementDTOToUserAccount(AdvertisementDTO advertisementDTO) {
        if ( advertisementDTO == null ) {
            return null;
        }

        UserAccount userAccount = new UserAccount();

        userAccount.setUsername( advertisementDTO.getUsername() );

        return userAccount;
    }

    protected RealEstate advertisementDTOToRealEstate(AdvertisementDTO advertisementDTO) {
        if ( advertisementDTO == null ) {
            return null;
        }

        RealEstate realEstate = new RealEstate();

        realEstate.setOwner( advertisementDTOToUserAccount( advertisementDTO ) );
        realEstate.setName( advertisementDTO.getName() );
        realEstate.setAddress( advertisementDTO.getAddress() );
        realEstate.setQuadrature( advertisementDTO.getQuadrature() );
        realEstate.setCapacity( advertisementDTO.getCapacity() );
        realEstate.setCategory( advertisementDTO.getCategory() );
        realEstate.setCity( advertisementDTO.getCity() );

        return realEstate;
    }
}

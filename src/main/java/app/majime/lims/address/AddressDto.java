package app.majime.lims.address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDto {

    Long id;
    String apartmentNumber;
    String city;
    String district;
    String houseNumber;
    String postCode;
    String street;
    String postOffice;
    String countryCode;
}

package app.majime.lims.address;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
@Builder
public class Address {

    @Id
    @SequenceGenerator(name="address_seq", sequenceName="address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private Long id;

    @NonNull
    private String apartmentNumber;

    @NonNull
    private String city;

    @NonNull
    private String district;

    @NonNull
    private String houseNumber;

    @NonNull
    private String postCode;

    @NonNull
    private String street;

    @NonNull
    private String postOffice;

    @NonNull
    private String countryCode;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    AddressDto toDto(){
        return AddressDto.builder()
                .id(id)
                .apartmentNumber(apartmentNumber)
                .city(city)
                .district(district)
                .houseNumber(houseNumber)
                .postCode(postCode)
                .street(street)
                .postOffice(postOffice)
                .countryCode(countryCode)
                .build();
    }

    static Address buildFrom(AddressDto addressDto) {
        return builder()
                .id(addressDto.getId())
                .apartmentNumber(addressDto.getApartmentNumber())
                .city(addressDto.getCity())
                .district(addressDto.getDistrict())
                .houseNumber(addressDto.getHouseNumber())
                .postCode(addressDto.getPostCode())
                .street(addressDto.getStreet())
                .postOffice(addressDto.getPostOffice())
                .countryCode(addressDto.getCountryCode())
                .deleted("false")
                .build();
    }

}

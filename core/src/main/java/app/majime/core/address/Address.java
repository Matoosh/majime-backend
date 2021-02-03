package app.majime.core.address;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString

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

    private char deleted;

    protected Address() {}
}

package app.majime.core.address;

import app.majime.core.manufacturer.Manufacturer;
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

    /*
    No i teraz jest pytanie, bo jak adres w tym jednym polu może odnosić się do 3 tablic? Nie może, bo będzie konflikt
    nazw kluczy. Więc w tym kierunku chyba nie mapujemy. Inna opcja to 3 osobne tabele z adresami albo włączyć adresy
    do tabel z Batch, Lab i Manufacturer
    @OneToOne(mappedBy="address")
    private Address address;
     */

    private char deleted;
}

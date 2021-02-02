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
    private String zipCode;

    @NonNull
    private String city;

    @NonNull
    private String street;

    @NonNull
    private String number;

    @NonNull
    private String country;

    private char deleted;

    protected Address() {}
}

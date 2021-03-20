package app.majime.lims.manufacturer;

import app.majime.lims.address.Address;
import app.majime.lims.batch.Batch;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString

public class Manufacturer {

    @Id
    @SequenceGenerator(name="manufacturer_seq", sequenceName="manufacturer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @OneToMany(mappedBy="manufacturer")
    private Set<Batch> batch;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}

package app.majime.lims.batch;

import app.majime.lims.address.Address;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
class Supplier {

    @Id
    @SequenceGenerator(name="supplier_seq", sequenceName="supplier_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    private Long id;

    @NonNull
    @Column(length = 50)
    private String name;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @OneToMany(mappedBy="manufacturer")
    private Set<Batch> batch;

    @OneToOne
    //@MapsId
    @JoinColumn(name = "address_id")
    private Address address;
}
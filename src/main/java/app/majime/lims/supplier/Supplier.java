package app.majime.lims.supplier;

import app.majime.lims.address.Address;
import app.majime.lims.utils.StatusDeleted;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class Supplier {

    @Id
    @SequenceGenerator(name="supplier_seq", sequenceName="supplier_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    //@OneToMany(mappedBy = "supplier")
    //private Set<User> SupplierUser;

    public SupplierDto toDto(){
        return SupplierDto.builder()
                .id(id)
                .name(name)
                .deleted(deleted)
                .address(address.toDto())
                .build();
    }

    public static Supplier buildFrom(SupplierDto dto) {
        return builder()
                .id(dto.getId())
                .name(dto.getName())
                .deleted(dto.getDeleted())
                .address(Address.buildFrom(dto.getAddress()))
                .build();
    }
}

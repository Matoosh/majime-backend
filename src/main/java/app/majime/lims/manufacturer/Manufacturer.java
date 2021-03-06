package app.majime.lims.manufacturer;

import app.majime.lims.address.Address;
import app.majime.lims.utils.StatusDeleted;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "manufacturer")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class Manufacturer {

    @Id
    @SequenceGenerator(name="manufacturer_seq", sequenceName="manufacturer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_seq")
    private Long id;

    @NonNull
    private String name;

    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public ManufacturerDto toDto(){
        return ManufacturerDto.builder()
                .id(id)
                .name(name)
                .deleted(deleted)
                .address(address.toDto())
                .build();
    }

    public static Manufacturer buildFrom(ManufacturerDto dto) {
        return builder()
                .id(dto.getId())
                .name(dto.getName())
                .deleted(dto.getDeleted())
                .address(Address.buildFrom(dto.getAddress()))
                .build();
    }
}

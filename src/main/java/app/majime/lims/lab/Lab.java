package app.majime.lims.lab;

import app.majime.lims.address.Address;
import app.majime.lims.user.User;
import app.majime.lims.utils.StatusDeleted;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "lab")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class Lab {

    @Id
    @SequenceGenerator(name="lab_seq", sequenceName="lab_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lab_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Enumerated(STRING)
    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "lab")
    private Set<User> labUsers;

    public LabDto toDto(){
        return LabDto.builder()
                .id(id)
                .name(name)
                .deleted(deleted)
                .address(address.toDto())
                .build();
    }

    public static Lab buildFrom(LabDto labDto) {
        return builder()
                .id(labDto.getId())
                .name(labDto.getName())
                .deleted(labDto.getDeleted())
                .address(Address.buildFrom(labDto.getAddress()))
                .build();
    }
}

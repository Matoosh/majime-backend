package app.majime.lims.lab;

import app.majime.lims.address.Address;
import app.majime.lims.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
    private String deleted;

    private String createdBy;

    private String reason;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "lab")
    private Set<User> LabUser;

    LabDto toDto(){
        return LabDto.builder()
                .id(id)
                .name(name)
                .build();
    }

    static Lab buildFrom(LabDto labDto) {
        return builder()
                .id(labDto.getId())
                .name(labDto.getName())
                .deleted("false")
                .build();
    }
}

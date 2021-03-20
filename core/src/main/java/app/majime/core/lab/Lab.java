package app.majime.core.lab;

import app.majime.core.address.Address;
import app.majime.core.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lab")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString

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
}

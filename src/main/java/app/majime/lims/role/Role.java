package app.majime.lims.role;

import app.majime.lims.utils.StatusDeleted;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
public class Role {

    @Id
    @SequenceGenerator(name="role_seq", sequenceName="role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Enumerated(STRING)
    private StatusDeleted deleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"))
    private Collection<Permission> permissions;


}

package app.majime.lims.user;

import org.springframework.security.core.GrantedAuthority;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
public class Role implements GrantedAuthority {

    @Id
    @SequenceGenerator(name="role_seq", sequenceName="role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Long id;

    @NonNull
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
//
//    @NonNull
//    private String code;
//
//    @NonNull
//    private String description;
//
//    @NonNull
//    private String deleted;
//
//    private String createdBy;
//
//    private String reason;
//
//    @OneToMany(mappedBy = "role")
//    private Set<RolePermission> rolePermissions;

}

package app.majime.core.role;

import app.majime.core.rolePermission.RolePermission;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Role {

    @Id
    @SequenceGenerator(name="role_seq", sequenceName="role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String code;

    @NonNull
    private String description;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("role")
    private Set<RolePermission> rolePermissions;

}

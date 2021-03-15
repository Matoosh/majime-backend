package app.majime.core.rolePermission;

import app.majime.core.permission.Permission;
import app.majime.core.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class RolePermission {

    @Id
    @SequenceGenerator(name="role_permission_seq", sequenceName="role_permission_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_permission_seq")
    private Long id;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties("rolePermissions")
    private Role role;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "permission_id")
    @JsonIgnoreProperties("rolePermissions")
    private Permission permission;


}

package app.majime.core.rolePermission;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class RolePermission {

    @Id
    @SequenceGenerator(name="role_permission_seq", sequenceName="role_permission_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_permission_seq")
    private Long id;

    @NonNull
    private Long roleId;

    @NonNull
    private Long permissionId;

    protected RolePermission() {}
}

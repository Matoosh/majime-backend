package app.majime.core.permission;

import app.majime.core.rolePermission.RolePermission;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
public class Permission {

    @Id
    @SequenceGenerator(name="permission_seq", sequenceName="permission_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
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
    @JsonIgnoreProperties("permission")
    private Set<RolePermission> rolePermissions;

}

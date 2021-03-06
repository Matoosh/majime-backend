package app.majime.lims.role;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
public
class Permission {

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

}

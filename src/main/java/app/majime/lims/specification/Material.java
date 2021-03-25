package app.majime.lims.specification;

import app.majime.lims.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "material")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class Material {

    @Id
    @SequenceGenerator(name="material_seq", sequenceName="material_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @OneToMany(mappedBy = "material")
    private Set<Specification> materialSpecifications;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("users")
    private User user;
}

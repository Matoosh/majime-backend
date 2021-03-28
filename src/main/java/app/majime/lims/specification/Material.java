package app.majime.lims.specification;

import app.majime.lims.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

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
    @GeneratedValue(strategy = SEQUENCE, generator = "material_seq")
    private Long id;

    private String name;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @OneToMany(mappedBy = "material")
    @JsonIgnoreProperties("material")
    private Set<Specification> specifications;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("users")
    private User user;

    public MaterialDto toDto(){
        return MaterialDto.builder()
                .id(id)
                .name(name)
                .deleted(deleted)
                .build();
    }

    public static Material buildFrom(MaterialDto materialDto) {
        return builder()
                .id(materialDto.getId())
                .name(materialDto.getName())
                .deleted("false")
                .build();
    }
}

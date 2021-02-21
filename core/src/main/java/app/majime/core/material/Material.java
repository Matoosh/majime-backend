package app.majime.core.material;

import app.majime.core.sampleLab.SampleLab;
import app.majime.core.specification.Specification;
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

public class Material {

    @Id
    @SequenceGenerator(name="material_seq", sequenceName="material_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq")
    private Long id;

    @NonNull
    private String name;

    private Long userId;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Specification> materialSpecifications;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "material_id")
    @JsonIgnoreProperties("materials")
    private Material material;
}

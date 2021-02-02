package app.majime.core.material;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "material")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString

public class Material {

    @Id
    @SequenceGenerator(name="material_seq", sequenceName="material_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq")
    private Long id;

    @NonNull
    private String name;

    private Long userId;

    protected Material() {}
}

package app.majime.core.parameter;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Parameter {

    @Id
    @SequenceGenerator(name="parameter_seq", sequenceName="parameter_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter_seq")
    private Long id;

    @NonNull
    private String name;

    private String type;

    // limit changed to border == limit is SQL sensitive
    private int border;

    private int unitId;

    private int specificationId;

}

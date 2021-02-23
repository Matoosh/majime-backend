package app.majime.core.parameter;

import app.majime.core.specification.Specification;
import app.majime.core.unit.Unit;
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

    private int border;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "specification_id")
    private Specification specification;

}

package app.majime.lims.parameter;

import app.majime.lims.specification.Specification;
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

    private String name;

    private String type;

    private String border;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    private String accuracy;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "specification_id")
    private Specification specification;

}

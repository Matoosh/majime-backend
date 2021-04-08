package app.majime.lims.parameter;

import app.majime.lims.specification.Specification;
import app.majime.lims.specification.SpecificationDto;
import app.majime.lims.utils.StatusDeleted;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "parameter")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class Parameter {

    @Id
    @SequenceGenerator(name="parameter_seq", sequenceName="parameter_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "parameter_seq")
    private Long id;

    private String name;

    private String type;

    private String border;

    @NonNull
    @Enumerated(STRING)
    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    private String accuracy;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "specification_id")
    private Specification specification;

    public ParameterDto toDto(){
        return ParameterDto.builder()
                .id(id)
                .name(name)
                .type(type)
                .border(border)
                .accuracy(accuracy)
                .deleted(deleted)
                .specification(specification.toDto())
                .build();
    }

    public static Parameter buildFrom (ParameterDto parameterDto){
        return builder()
                .id(parameterDto.getId())
                .name(parameterDto.getName())
                .type(parameterDto.getType())
                .border(parameterDto.getBorder())
                .accuracy(parameterDto.getAccuracy())
                .deleted(StatusDeleted.FALSE)
                .specification(Specification.buildFrom(parameterDto.getSpecification() ))
                .build();
    }
}

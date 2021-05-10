package app.majime.lims.result;

import app.majime.lims.parameter.Parameter;
import app.majime.lims.sample.Sample;
import app.majime.lims.user.User;
import app.majime.lims.utils.StatusDeleted;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "result")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
@Builder
public class Result {

    @Id
    @SequenceGenerator(name="result_seq", sequenceName="result_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_seq")
    private Long id;

    private String value;

    @NonNull
    @Enumerated(STRING)
    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    // STATUS:
    @Enumerated(STRING)
    private ResultStatus status;

    @ManyToOne
    @JoinColumn(name = "sample_id")
    private Sample sample;

    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    ResultDto toDto(){
        return ResultDto.builder()
                .id(id)
                .value(value)
                .sample(sample.toDto())
                .parameter(parameter.toDto())
                .deleted(deleted)
                .status(status)
                .build();
    }

    public static Result buildFrom(ResultDto resultDto){
        return builder()
                .id(resultDto.getId())
                .value(resultDto.getValue())
                .sample(Sample.buildFrom(resultDto.getSample()))
                .parameter(Parameter.buildFrom(resultDto.getParameter()))
                .deleted(StatusDeleted.FALSE)
                .status(resultDto.getStatus())
                .build();
    }

}

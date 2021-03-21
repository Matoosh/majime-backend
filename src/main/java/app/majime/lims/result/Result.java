package app.majime.lims.result;

import app.majime.lims.parameter.Parameter;
import app.majime.lims.sample.Sample;
import app.majime.lims.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "result")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
public class Result {

    @Id
    @SequenceGenerator(name="result_seq", sequenceName="result_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_seq")
    private Long id;

    private String value;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    // STATUS:
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
}

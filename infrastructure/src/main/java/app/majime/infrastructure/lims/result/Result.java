package app.majime.infrastructure.lims.result;

import app.majime.infrastructure.lims.dictionary.Dictionary;
import app.majime.infrastructure.lims.parameter.Parameter;
import app.majime.infrastructure.lims.sample.Sample;
import app.majime.infrastructure.lims.user.User;
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
    @ManyToOne
    @JoinColumn(name = "status")
    private Dictionary dictionary;

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

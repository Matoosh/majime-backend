package app.majime.core.result;

import app.majime.core.dictionary.Dictionary;
import app.majime.core.outOfSpec.OutOfSpec;
import app.majime.core.parameter.Parameter;
import app.majime.core.sample.Sample;
import app.majime.core.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "result", schema = "public")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Result {

    @Id
    @SequenceGenerator(name="result_seq", sequenceName="result_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_seq")
    private Long id;

    private String value;

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

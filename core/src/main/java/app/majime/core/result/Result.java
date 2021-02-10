package app.majime.core.result;

import app.majime.core.outOfSpec.OutOfSpec;
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

    private int status;

    private Long sampleId;

    private Long parameterId;

    private Long userId;

    @OneToOne(mappedBy = "result")
    private OutOfSpec outOfSpec;

}

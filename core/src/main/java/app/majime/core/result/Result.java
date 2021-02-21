package app.majime.core.result;

import app.majime.core.dictionary.Dictionary;
import app.majime.core.sample.Sample;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
/* error here
    private Long sampleId;

    private Long parameterId;

    private Long userId;
*/
    @NonNull
    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    @JsonIgnoreProperties("dictionaryResult")
    private Dictionary dictionary;

}

package app.majime.core.specification;

import app.majime.core.dictionary.Dictionary;
import app.majime.core.sample.Sample;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "specification")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Specification {
    @Id
    @SequenceGenerator(name="specification_seq", sequenceName="specification_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specification_seq")
    private Long id;

    @NonNull
    @Column(unique = true, length = 50)
    private String specificationNo;

    @NonNull
    @Column(length = 1)
    private String confirmed;

    @NonNull
    private Long materialId;

    private Long acceptedBy;

    @NonNull
    private Long userId;

    @NonNull
    private Long status;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    @JsonIgnoreProperties("dictionarySpecification")
    private Dictionary dictionary;
}

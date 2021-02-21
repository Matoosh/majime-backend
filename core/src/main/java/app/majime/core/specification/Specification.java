package app.majime.core.specification;

import app.majime.core.dictionary.Dictionary;
import app.majime.core.sample.Sample;
import app.majime.core.sampleLab.SampleLab;
import app.majime.core.specificationStatusHistory.SpecificationStatusHistory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
/* error here
    @NonNull
    private Long materialId;
*/
    private Long acceptedBy;
/* error here
    @NonNull
    private Long userId;
*/
    @NonNull
    private Long status;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    @JsonIgnoreProperties("dictionarySpecification")
    private Dictionary dictionary;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "material_id")
    @JsonIgnoreProperties("materialSpecifications")
    private Specification specification;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<SpecificationStatusHistory> specificationStatusHistories;

}

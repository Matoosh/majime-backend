package app.majime.infrastructure.lims.dictionary;

import app.majime.infrastructure.lims.result.Result;
import app.majime.infrastructure.lims.specification.Specification;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dictionary")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class Dictionary {

    @Id
    @SequenceGenerator(name="dictionary_seq", sequenceName="dictionary_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_seq")
    private Long id;

    @NonNull
    private String dictionaryCode;

    @NonNull
    private String code;

    @NonNull
    private String value;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

//    @OneToMany(mappedBy = "dictionary")
//    private Set<Sample> dictionarySample;

    @OneToMany(mappedBy = "dictionary")
    private Set<Result> dictionaryResult;

    @OneToMany(mappedBy = "status")
    private Set<Specification> dictionarySpecification;
}

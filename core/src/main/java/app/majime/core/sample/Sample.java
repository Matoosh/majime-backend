package app.majime.core.sample;

import app.majime.core.dictionary.Dictionary;
import app.majime.core.sample.usecase.SampleOperations;
import app.majime.core.sampleLab.SampleLab;
import app.majime.core.sampleStatusHistory.SampleStatusHistory;
import app.majime.core.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sample")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Sample implements SampleOperations {

    @Id
    @SequenceGenerator(name="sample_seq", sequenceName="sample_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_seq")
    private Long id;

    @NonNull
    @Column(name = "sample_no", length = 50)
    private String sampleNo;

    @NonNull
    private int quantity;

    @NonNull
    private Long status;

    @NonNull
    private Long batchId;

    @NonNull
    private Long specificationId;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("samples")
    private User user;

    //TODO @ManyToOne from SampleLab if necessary
    @OneToMany(fetch = FetchType.LAZY)
    private Set<SampleLab> sampleLabs;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    @JsonIgnoreProperties("dictionaryResult")
    private Dictionary dictionary;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<SampleStatusHistory> sampleStatusHistory;

    @Override
    public void addSampleLab(SampleLab sampleLab) {
        sampleLabs.add(sampleLab);
//        sampleLab.setSample(this);
    }

    @Override
    public void removeSampleLab(SampleLab sampleLab) {
        sampleLabs.add(sampleLab);
//        sampleLab.setSample(this);
    }
}

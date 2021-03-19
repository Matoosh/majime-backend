package app.majime.infrastructure.lims.sample;

import app.majime.core.dictionary.Dictionary;
import app.majime.core.sampleLab.SampleLab;
import app.majime.core.sampleStatusHistory.SampleStatusHistory;
import app.majime.core.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.EnumType.ORDINAL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PROTECTED;


@Entity
@Table(name = "sample")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@ToString
@Builder
class SampleNew {

    @Id
    @SequenceGenerator(name = "sample_seq", sequenceName = "sample_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "sample_seq")
    private Long id;

    @NonNull
    @Column(name = "sample_no", length = 50)
    private String sampleNo;

    @NonNull
    private int quantity;

    @NonNull
    @Enumerated(ORDINAL)
    private SampleStatus status;

    @NonNull
    private Long batchId;

    @NonNull
    private Long specificationId;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    //fixme Chyba już nie potrzebujesz JsonIgnore jeżeli oerujesz na dto
    @JsonIgnoreProperties("samples")
    private User user;

    //TODO @ManyToOne from SampleLab if necessary
    @OneToMany(fetch = LAZY)
    private Set<SampleLab> sampleLabs;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    //fixme Chyba już nie potrzebujesz JsonIgnore jeżeli oerujesz na dto
    @JsonIgnoreProperties("dictionaryResult")
    private Dictionary dictionary;

    @OneToMany(fetch = LAZY)
    private Set<SampleStatusHistory> sampleStatusHistory;

    void addSampleLab(SampleLab sampleLab) {
        sampleLabs.add(sampleLab);
//        sampleLab.setSample(this);
    }

    void removeSampleLab(SampleLab sampleLab) {
        sampleLabs.add(sampleLab);
//        sampleLab.setSample(this);
    }

    SampleDto toDto() {
        return SampleDto.builder()
                .id(id)
                .quantity(quantity)
                .sampleNo(sampleNo)
                .status(status)
                .build();
    }

    static SampleNew buildFrom(SampleDto sampleDto) {
        return builder()
                .id(sampleDto.getId())
                .quantity(sampleDto.getQuantity())
                .sampleNo(sampleDto.getSampleNo())
                .status(sampleDto.getStatus())
                .build();
    }
}

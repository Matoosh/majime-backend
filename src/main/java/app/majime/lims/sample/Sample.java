package app.majime.lims.sample;

import app.majime.lims.batch.Batch;
import app.majime.lims.sampleLab.SampleLab;
import app.majime.lims.specification.Specification;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
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
public class Sample {

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
    @Enumerated(STRING)
    private SampleStatus status;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    @ManyToOne
    @JoinColumn(name = "specification_id")
    private Specification specification;

    //TODO @ManyToOne from SampleLab if necessary
    @OneToMany(fetch = LAZY,mappedBy = "sample")
    private Set<SampleLab> sampleLabs;

    @OneToMany(fetch = LAZY,mappedBy = "sample")
    private Set<SampleStatusHistory> sampleStatusHistory;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    private String type;

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

    static Sample buildFrom(SampleDto sampleDto) {
        return builder()
                .id(sampleDto.getId())
                .quantity(sampleDto.getQuantity())
                .sampleNo(sampleDto.getSampleNo())
                .status(sampleDto.getStatus())
                .deleted("false")
                .build();
    }
}

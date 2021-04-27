package app.majime.lims.sample;

import app.majime.lims.batch.Batch;
import app.majime.lims.sampleLab.SampleLab;
import app.majime.lims.specification.Specification;
import app.majime.lims.utils.StatusDeleted;
import app.majime.lims.utils.Type;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String name;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @NonNull
    @Column(name = "sample_no", length = 50)
    private String sampleNo;

    @NonNull
    private int quantity;

    @Enumerated(STRING)
    private SampleStatus status;

    @NonNull
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

    @Enumerated(STRING)
    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    @Enumerated(STRING)
    private Type type;

    void addSampleLab(SampleLab sampleLab) {
        sampleLabs.add(sampleLab);
//        sampleLab.setSample(this);
    }

    void removeSampleLab(SampleLab sampleLab) {
        sampleLabs.add(sampleLab);
//        sampleLab.setSample(this);
    }

    public SampleDto toDto() {
        return SampleDto.builder()
                .id(id)
                .name(name)
                .createdAt(createdAt)
                .quantity(quantity)
                .batch(batch.toDto())
                .sampleNo(sampleNo)
                .status(status)
                .type(type)
                .deleted(deleted)
                .specification(specification.toDto())
                .build();
    }

    public static Sample buildFrom(SampleDto sampleDto) {
        return builder()
                .id(sampleDto.getId())
                .name(sampleDto.getName())
                .createdAt(sampleDto.getCreatedAt())
                .quantity(sampleDto.getQuantity())
                .batch(Batch.buildFrom(sampleDto.getBatch()))
                .sampleNo(sampleDto.getSampleNo())
                .status(sampleDto.getStatus())
                .type(sampleDto.getType())
                .specification(Specification.buildFrom(sampleDto.getSpecification()))
                .build();
    }
}

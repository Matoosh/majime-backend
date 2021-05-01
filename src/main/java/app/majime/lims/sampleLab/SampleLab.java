package app.majime.lims.sampleLab;

import app.majime.lims.lab.Lab;
import app.majime.lims.sample.Sample;
import app.majime.lims.utils.StatusDeleted;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "sample_lab")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class SampleLab {
    @Id
    @SequenceGenerator(name="sample_lab_seq", sequenceName="sample_lab_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_lab_seq")
    private Long id;

    @NonNull
    private String quantity;

    @NonNull
    @Enumerated(STRING)
    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "sample_id")
    @JsonIgnoreProperties("sampleLabs")
    private Sample sample;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "lab_id")
    @JsonIgnoreProperties("labsSamples")
    private Lab lab;


    public SampleLabDto toDto() {
        return SampleLabDto.builder()
                .id(id)
                .deleted(deleted)
                .createdBy(createdBy)
                .reason(reason)
                .quantity(quantity)
                .sample(sample.toDto())
                .lab(lab.toDto())
                .build();
    }

    public static SampleLab buildFrom(SampleLabDto sampleLabDto) {
        return builder()
                .id(sampleLabDto.getId())
                .deleted(sampleLabDto.getDeleted())
                .createdBy(sampleLabDto.getCreatedBy())
                .reason(sampleLabDto.getReason())
                .quantity(sampleLabDto.getQuantity())
                .sample(Sample.buildFrom(sampleLabDto.getSample()))
                .lab(Lab.buildFrom(sampleLabDto.getLab()))
                .build();
    }
}

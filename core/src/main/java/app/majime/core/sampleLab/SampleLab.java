package app.majime.core.sampleLab;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sample_lab")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SampleLab {
    @Id
    @SequenceGenerator(name="sample_lab_seq", sequenceName="sample_lab_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_lab_seq")
    private Long id;

    @NonNull
    private int quantity;

    @NonNull
    private Long sampleId;

    @NonNull
    private Long labId;
}

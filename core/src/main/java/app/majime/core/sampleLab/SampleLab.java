package app.majime.core.sampleLab;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sample_lab")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class SampleLab {
    @Id
    @SequenceGenerator(name="sample_lab_seq", sequenceName="sample_lab_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_lab_seq")
    private Long id;

    @Column
    private int quantity;

    @Column
    private Long sampleId;

    @Column
    private Long labId;
}

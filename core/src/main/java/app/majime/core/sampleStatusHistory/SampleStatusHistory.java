package app.majime.core.sampleStatusHistory;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sample_status_history")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class SampleStatusHistory {
    @Id
    @SequenceGenerator(name="sample_status_history_seq", sequenceName="sample_status_history_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_status_history_seq")
    private Long id;

    @Column(length = 50, nullable = false)
    private String oldValue;

    @Column(length = 50, nullable = false)
    private String newValue;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long sampleId;
}

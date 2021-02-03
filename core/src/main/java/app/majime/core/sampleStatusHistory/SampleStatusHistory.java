package app.majime.core.sampleStatusHistory;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sample_status_history")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SampleStatusHistory {
    @Id
    @SequenceGenerator(name="sample_status_history_seq", sequenceName="sample_status_history_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_status_history_seq")
    private Long id;

    @NonNull
    @Column(length = 50)
    private String oldValue;

    @NonNull
    @Column(length = 50)
    private String newValue;

    @NonNull
    private Long userId;

    @NonNull
    private Long sampleId;
}

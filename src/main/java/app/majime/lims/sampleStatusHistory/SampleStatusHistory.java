package app.majime.lims.sampleStatusHistory;

import app.majime.lims.sample.Sample;
import app.majime.lims.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String deleted;

    private String createdBy;

    private String reason;

    @NonNull
    @Column(length = 50)
    private String oldValue;

    @NonNull
    @Column(length = 50)
    private String newValue;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("users")
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "sample_id")
    @JsonIgnoreProperties("samples")
    private Sample sample;

}

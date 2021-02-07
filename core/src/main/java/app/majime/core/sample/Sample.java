package app.majime.core.sample;

import app.majime.core.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sample")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Sample {

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("samples")
    private User user;

}

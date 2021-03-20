package app.majime.lims.certificate;

import app.majime.lims.batch.Batch;
import app.majime.lims.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "certificate")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class Certificate {

    @Id
    @SequenceGenerator(name="certificate_seq", sequenceName="certificate_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificate_seq")
    private Long id;

    @NonNull
    private String certificateNo;

    @NonNull
    private String name;

    @NonNull
    private Long acceptedBy;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "batch_id")
    @JsonIgnoreProperties("batchCertificates")
    private Batch batch;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("userCertificates")
    private User user;

}

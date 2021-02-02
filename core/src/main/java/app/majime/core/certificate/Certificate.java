package app.majime.core.certificate;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "certificate")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
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
    private Long batchId;

    @NonNull
    private Long acceptedBy;

    private char deleted;

    protected Certificate() {}
}

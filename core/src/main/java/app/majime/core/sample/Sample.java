package app.majime.core.sample;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sample")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Sample {

    @Id
    @SequenceGenerator(name="sample_seq", sequenceName="sample_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_seq")
    private Long id;

    @NonNull
    @Column(name = "sample_no")
    private String sampleNo;

    private int quantity;

    private int status;

    private int batch_id;

    private int user_id;

    private int specification_id;

    protected Sample() {}

}

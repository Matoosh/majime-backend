package app.majime.core.sample;

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

    @Column(name = "sample_no", length = 50, nullable = false)
    private String sampleNo;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Long status;

    @Column(nullable = false)
    private Long batch_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Long specification_id;


}

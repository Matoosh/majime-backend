package app.majime.infrastructure.lims.result;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "out_of_spec")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class OutOfSpec {

    @Id
    @SequenceGenerator(name="out_of_spec_seq", sequenceName="out_of_spec_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "out_of_spec_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String simple_investigation;

    private String complete_investigation;

    private String error;

    @NonNull
    private String value;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @OneToOne
    @JoinColumn(name = "result_id")
    private Result result;
}

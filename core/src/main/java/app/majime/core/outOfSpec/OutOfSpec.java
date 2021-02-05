package app.majime.core.outOfSpec;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "out_of_spec")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class OutOfSpec {

    @Id
    @SequenceGenerator(name="out_of_spec_seq", sequenceName="out_of_spec_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "out_of_spec_seq")
    private Long id;

    @NonNull
    private String text;

    private char error;

    @NonNull
    private String value;

    private Long resultId;

    protected OutOfSpec() {}
}

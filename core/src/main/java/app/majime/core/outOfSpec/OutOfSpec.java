package app.majime.core.outOfSpec;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "outofspec")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class OutOfSpec {

    @Id
    @SequenceGenerator(name="outofspec_seq", sequenceName="outofspec_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outofspec_seq")
    private Long id;

    @NonNull
    private String text;

    private char error;

    @NonNull
    private String value;

    private Long resultId;

    protected OutOfSpec() {}
}

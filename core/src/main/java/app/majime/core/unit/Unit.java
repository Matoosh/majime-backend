package app.majime.core.unit;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "unit", schema = "public")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Unit {

    @Id
    @SequenceGenerator(name="unit_seq", sequenceName="unit_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq")
    private Long id;

    private String name;

    private String value;

    private Long user_id;
}

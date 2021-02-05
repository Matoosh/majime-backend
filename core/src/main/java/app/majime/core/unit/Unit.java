package app.majime.core.unit;

import app.majime.core.user.User;
import lombok.*;

import javax.persistence.*;

@Entity(name = "Unit")
@Table(name = "unit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@RequiredArgsConstructor
@ToString
public class Unit {

    @Id
    @SequenceGenerator(name="unit_seq", sequenceName="unit_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package app.majime.lims.parameter;

import app.majime.lims.user.User;
import lombok.*;

import javax.persistence.*;

@Table(name = "unit")
@Entity()
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
class Unit {

    @Id
    @SequenceGenerator(name="unit_seq", sequenceName="unit_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String value;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

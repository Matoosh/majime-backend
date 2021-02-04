package app.majime.core.user;

import app.majime.core.sample.Sample;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lab_user")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {

    @Id
    @SequenceGenerator(name="user_seq", sequenceName="user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String login;

    @NonNull
    private String password;

    @NonNull
    private String email;

    private String phone;

    private Long roleId;

    private Long labId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Sample> samples;

    protected User() {}

}

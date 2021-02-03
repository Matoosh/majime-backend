package app.majime.core.user;

import app.majime.core.sample.Sample;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user",schema = "public")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "login")
    private String login;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "email")
    private String email;

    private String phone;

    private int status;

    private int batch_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Sample> samples;

    protected User() {}

}

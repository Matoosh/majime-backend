package app.majime.core.user;

import app.majime.core.sample.Sample;
import app.majime.core.user.usecase.SampleOperations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class User implements SampleOperations {

    @Id
    @SequenceGenerator(name="user_seq", sequenceName="lab_user_id_seq", allocationSize = 1)
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

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties("user")
    private Set<Sample> samples;

    @Override
    public void addSample(Sample sample){
        samples.add(sample);
        sample.setUser(this);
    }

    @Override
    public void removeSample(Sample sample){
        samples.remove(sample);
        sample.setUser(this);
    }

    protected User() {}

}

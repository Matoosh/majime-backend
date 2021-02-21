package app.majime.core.user;

import app.majime.core.batch.Batch;
import app.majime.core.certificate.Certificate;
import app.majime.core.lab.Lab;
import app.majime.core.material.Material;
import app.majime.core.result.Result;
import app.majime.core.resultStatusHistory.ResultStatusHistory;
import app.majime.core.role.Role;
import app.majime.core.sample.Sample;
import app.majime.core.sampleStatusHistory.SampleStatusHistory;
import app.majime.core.specification.Specification;
import app.majime.core.specificationStatusHistory.SpecificationStatusHistory;
import app.majime.core.unit.Unit;
import app.majime.core.user.usecase.UserOperations;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User implements UserOperations {

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

    @NonNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Certificate> certificates;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Batch> batches;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    @JsonIgnoreProperties("users")
    private Lab lab;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<SampleStatusHistory> sampleStatusHistories;

    //Bidirectional
    @OneToMany(fetch = FetchType.LAZY)
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

    //Unidirectional
    @OneToMany(fetch = FetchType.LAZY)
    private Set<SpecificationStatusHistory> specificationStatusHistories;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Specification> specifications;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Material> materials;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Unit> units;

}

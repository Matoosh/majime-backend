package app.majime.lims.user;

import app.majime.lims.batch.Batch;
import app.majime.lims.certificate.Certificate;
import app.majime.lims.lab.Lab;
import app.majime.lims.specification.Specification;
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
public class User {

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
    private String deleted;

    private String createdBy;

    private String reason;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Certificate> certificates;

    @OneToMany(mappedBy = "user")
    private Set<Batch> batches;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    @JsonIgnoreProperties("users")
    private Lab lab;

//    @OneToMany(mappedBy = "user")
//    private Set<SampleStatusHistory> sampleStatusHistories;
//
//    //Unidirectional
//    @OneToMany(mappedBy = "user")
//    private Set<SpecificationStatusHistory> specificationStatusHistories;

    @OneToMany(mappedBy = "user")
    private Set<Specification> specifications;

}

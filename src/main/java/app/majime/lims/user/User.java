package app.majime.lims.user;

import app.majime.lims.batch.Batch;
import app.majime.lims.certificate.Certificate;
import app.majime.lims.lab.Lab;
import app.majime.lims.specification.Specification;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lab_user")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
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
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    private String phone;

    @NonNull
    private String deleted;

    private String createdBy;
//    created_by

    private String reason;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
//
    @OneToMany(mappedBy = "user")
    private Set<Certificate> certificates;
//
    @OneToMany(mappedBy = "user")
    private Set<Batch> batches;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    @JsonIgnoreProperties("users")
    private Lab lab;

    @OneToMany(mappedBy = "user")
    private Set<Specification> specifications;

    static User buildFrom(UserDto user) {
        return User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .phone(user.getPhone())
                .deleted(user.getDeleted())
                .role(user.getRole())
                .build();
    }
}

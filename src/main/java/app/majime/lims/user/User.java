package app.majime.lims.user;

import app.majime.lims.batch.Batch;
import app.majime.lims.certificate.Certificate;
import app.majime.lims.lab.Lab;
import app.majime.lims.role.Role;
import app.majime.lims.user.dto.UserRead;
import app.majime.lims.user.dto.UserWrite;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
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
    private String password;

    @NonNull
    private String email;

    private String phone;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

//    @NonNull
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Certificate> certificates;

    @OneToMany(mappedBy = "user")
    private Set<Batch> batches;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    @JsonIgnoreProperties("labUsers")
    private Lab lab;

    static User buildFrom(UserWrite user) {
        return User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .email(user.getEmail())
                .phone(user.getPhone())
                .deleted(user.getDeleted())
                .roles(user.getRoles())
                //.lab(Lab.buildFrom(user.getLab()))
                .build();
    }

    static UserRead toUserRead(User user) {
        return UserRead.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .deleted(user.getDeleted())
                .roles(user.getRoles())
                .build();
    }

}

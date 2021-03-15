package app.majime.core.specificationStatusHistory;

import app.majime.core.specification.Specification;
import app.majime.core.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "specification_status_history")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SpecificationStatusHistory {
    @Id
    @SequenceGenerator(name="specification_status_history_seq", sequenceName="specification_status_history_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specification_status_history_seq")
    private Long id;

    @NonNull
    @Column(length = 50)
    private String oldValue;

    @NonNull
    @Column(length = 50)
    private String newValue;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("users")
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "specification_id")
    @JsonIgnoreProperties("specifications")
    private Specification specification;

}

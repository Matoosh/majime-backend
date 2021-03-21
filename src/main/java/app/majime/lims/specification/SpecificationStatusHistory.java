package app.majime.lims.specification;

import app.majime.lims.user.User;
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
class SpecificationStatusHistory {
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specification_id")
    private Specification specification;

}

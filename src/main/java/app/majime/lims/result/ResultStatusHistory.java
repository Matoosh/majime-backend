package app.majime.lims.result;

import app.majime.lims.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "result_status_history")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
class ResultStatusHistory {
    @Id
    @SequenceGenerator(name="result_status_history_seq", sequenceName="result_status_history_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_status_history_seq")
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

    @ManyToOne
    @JoinColumn(name = "result_id")
    private Result result;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
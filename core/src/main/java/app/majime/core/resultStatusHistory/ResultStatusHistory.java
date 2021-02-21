package app.majime.core.resultStatusHistory;

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
public class ResultStatusHistory {
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
/* error here
    @NonNull
    private Long resultId;

    @NonNull
    private Long userId;
*/
}

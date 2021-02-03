package app.majime.core.specificationStatusHistory;

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
    private Long specificationId;

    @NonNull
    private Long userId;
}

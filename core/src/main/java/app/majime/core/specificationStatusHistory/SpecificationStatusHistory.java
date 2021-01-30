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

    @Column(length = 50, nullable = false)
    private String oldValue;

    @Column(length = 50, nullable = false)
    private String newValue;

    @Column(nullable = false)
    private Long specificationId;

    @Column(nullable = false)
    private Long userId;
}

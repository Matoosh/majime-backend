package app.majime.core.specification;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "specification")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Specification {
    @Id
    @SequenceGenerator(name="specification_seq", sequenceName="specification_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specification_seq")
    private Long id;

    @Column(unique = true, length = 50, nullable = false)
    private String specificationNo;

    @Column(length = 1, nullable = false)
    private String confirmed;

    @Column(nullable = false)
    private Long materialId;

    @Column
    private Long acceptedBy;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long status;
}

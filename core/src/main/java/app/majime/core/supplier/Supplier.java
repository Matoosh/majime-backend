package app.majime.core.supplier;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Supplier {
    @Id
    @SequenceGenerator(name="supplier_seq", sequenceName="supplier_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    private Long id;

    @NonNull
    @Column(length = 50)
    private String name;

    @NonNull
    @Column(length = 1)
    private String deleted;

    @NonNull
    private Long addressId;
}

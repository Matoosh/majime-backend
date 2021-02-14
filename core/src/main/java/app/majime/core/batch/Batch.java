package app.majime.core.batch;

import app.majime.core.manufacturer.Manufacturer;
import app.majime.core.supplier.Supplier;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString

public class Batch {

    @Id
    @SequenceGenerator(name="batch_seq", sequenceName="batch_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_seq")
    private Long id;

    @NonNull
    private String batchNo;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @NonNull
    private Long userId;

    @NonNull
    @Column(length = 1)
    private String deleted;
}

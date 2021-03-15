package app.majime.core.batch;

import app.majime.core.certificate.Certificate;
import app.majime.core.manufacturer.Manufacturer;
import app.majime.core.supplier.Supplier;
import app.majime.core.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    private String internalBatchNo;

    private String manufacturerBatchNo;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Certificate> batchCertificates;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

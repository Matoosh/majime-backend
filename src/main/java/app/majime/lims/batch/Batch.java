package app.majime.lims.batch;

import app.majime.lims.certificate.Certificate;
import app.majime.lims.specification.Material;
import app.majime.lims.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
@Builder
public class Batch {

    @Id
    @SequenceGenerator(name="batch_seq", sequenceName="batch_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "batch_seq")
    private Long id;

    private String internalBatchNo;

    private String manufacturerBatchNo;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "batch")
    private Set<Certificate> batchCertificates;

    @ManyToOne()
    @JoinColumn(name = "material_id")
    private Material material;

//    @OneToMany(mappedBy = "batch")
//    private Set<Sample> batchSamples;

    public BatchDto toDto() {
        return BatchDto.builder()
                .id(id)
                .internalBatchNo(internalBatchNo)
                .manufacturerBatchNo(manufacturerBatchNo)
                .material(material.toDto())
                .build();
    }

    public static Batch buildFrom(BatchDto batchDTO) {
        return builder()
                .id(batchDTO.getId())
                .internalBatchNo(batchDTO.getInternalBatchNo())
                .manufacturerBatchNo(batchDTO.getManufacturerBatchNo())
                .material(Material.buildFrom(batchDTO.getMaterial()))
                .deleted("false")
                .build();
    }
}

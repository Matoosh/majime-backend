package app.majime.lims.batch;

import app.majime.lims.certificate.Certificate;
import app.majime.lims.manufacturer.Manufacturer;
import app.majime.lims.specification.Material;
import app.majime.lims.supplier.Supplier;
import app.majime.lims.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
                .manufacturer(manufacturer.toDto())
                .supplier(supplier.toDto())
                .build();
    }

    public static Batch buildFrom(BatchDto batchDTO) {
        return builder()
                .id(batchDTO.getId())
                .internalBatchNo(batchDTO.getInternalBatchNo())
                .manufacturerBatchNo(batchDTO.getManufacturerBatchNo())
                .material(Material.buildFrom(batchDTO.getMaterial()))
                .manufacturer(Manufacturer.buildFrom(batchDTO.getManufacturer()))
                .supplier(Supplier.buildFrom(batchDTO.getSupplier()))
                .deleted("false")
                .build();
    }
}

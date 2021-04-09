package app.majime.lims.specification;

import app.majime.lims.user.User;
import app.majime.lims.utils.StatusDeleted;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.EnumType.STRING;
@Entity
@Table(name = "specification")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class Specification {
    @Id
    @SequenceGenerator(name="specification_seq", sequenceName="specification_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "specification_seq")
    private Long id;

    @NonNull
    @Column(unique = true, length = 50)
    private String specificationNo;

    //@NonNull
    @Column(length = 1)
    private String confirmed;

    @NonNull
    private String name;

    @NonNull
    private String type;

    @NonNull
    @Enumerated(STRING)
    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    private SpecificationStatus status;
 
    @OneToMany(mappedBy = "specification")
    private Set<SpecificationStatusHistory> specificationStatusHistories;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "accepted_by")
    private User acceptedBy;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SpecificationDto toDto(){
        return SpecificationDto.builder()
                .id(id)
                .specificationNo(specificationNo)
                .name(name)
                .status(status)
                .type(type)
                .material(material.toDto())
                .deleted(deleted)
                .build();
    }

    public static Specification buildFrom(SpecificationDto specificationDto) {
        return builder()
                .id(specificationDto.getId())
                .specificationNo(specificationDto.getSpecificationNo())
                .name(specificationDto.getName())
                .status(specificationDto.getStatus())
                .type(specificationDto.getType())
                .material(Material.buildFrom(specificationDto.getMaterial()))
                .deleted(StatusDeleted.FALSE)
                .build();
    }
}

package app.majime.core.specification;

import app.majime.core.dictionary.Dictionary;
import app.majime.core.specificationStatusHistory.SpecificationStatusHistory;
import app.majime.core.material.Material;
import app.majime.core.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @NonNull
    @Column(unique = true, length = 50)
    private String specificationNo;

    @NonNull
    @Column(length = 1)
    private String confirmed;

    @NonNull
    private String name;

    @NonNull
    private String type;

    @NonNull
    private String deleted;

    private String createdBy;

    private String reason;
 
    @OneToMany(mappedBy = "specification")
    private Set<SpecificationStatusHistory> specificationStatusHistories;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "accepted_by")
    private User acceptedBy;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "status")
    private Dictionary status;


}

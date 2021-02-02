package app.majime.core.manufacturer;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "manufacturer", schema = "public")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString

public class Manufacturer {

    @Id
    @SequenceGenerator(name="manufacturer_seq", sequenceName="manufacturer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_seq")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "deleted")
    private char deleted;

    @Column(name = "address_id")
    private Long addressId;

    protected Manufacturer() {

    }
}

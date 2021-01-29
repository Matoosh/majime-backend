package app.majime.core.manufacturer;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "manufacturer")
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
    @Column(name = "manufacturer_no")
    private String name;
    private char deleted;
    private Long address_id;

    protected Manufacturer() {

    }
}

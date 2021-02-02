package app.majime.core.lab;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "lab")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString

public class Lab {

    @Id
    @SequenceGenerator(name="lab_seq", sequenceName="lab_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lab_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String adressId;

    private char deleted;

    protected Lab() {}
}

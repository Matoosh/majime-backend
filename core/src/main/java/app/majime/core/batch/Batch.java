package app.majime.core.batch;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "batch")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString

public class Batch {

    @Id
    @SequenceGenerator(name="batch_seq", sequenceName="batch_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_seq")
    private Long id;

    @NonNull
    private String batchNo;

    @NonNull
    private Long supplierId;

    @NonNull
    private Long manufacturerId;

    @NonNull
    private Long userId;

    private char deleted;

    protected Batch() {}
}

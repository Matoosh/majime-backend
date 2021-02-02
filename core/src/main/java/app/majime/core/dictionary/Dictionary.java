package app.majime.core.dictionary;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dictionary")
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@ToString

public class Dictionary {

    @Id
    @SequenceGenerator(name="dictionary_seq", sequenceName="dictionary_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_seq")
    private Long id;

    @NonNull
    private String dictionaryCode;

    @NonNull
    private String code;

    @NonNull
    private String value;

    private char deleted;

    protected Dictionary() {}
}

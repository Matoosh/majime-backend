package app.majime.lims.result;

import app.majime.lims.utils.StatusDeleted;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "out_of_spec")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
//@JsonIgnoreProperties(value = {"result"})
class OutOfSpec {

    @Id
    @SequenceGenerator(name="out_of_spec_seq", sequenceName="out_of_spec_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "out_of_spec_seq")
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String simple_investigation;

    private String complete_investigation;

    private String error;

    @NonNull
    private String value;

    //@NonNull
    private StatusDeleted deleted;

    private String createdBy;

    private String reason;

    //@JsonIgnoreProperties(value = {"result_id"})
    @OneToOne
    @JoinColumn(name = "result_id")
    private Result result;

    OutOfSpecDto toDto(){
        return OutOfSpecDto.builder()
                .id(id)
                .name(name)
                .simple_investigation(simple_investigation)
                .complete_investigation(complete_investigation)
                .error(error)
                .value(value)
                .result(result)
                .build();
    }

    public static OutOfSpec buildFrom(OutOfSpecDto outOfSpecDto){
        return builder()
                .id(outOfSpecDto.getId())
                .name(outOfSpecDto.getName())
                .simple_investigation(outOfSpecDto.getSimple_investigation())
                .complete_investigation(outOfSpecDto.getComplete_investigation())
                .error(outOfSpecDto.getError())
                .value(outOfSpecDto.getValue())
                .result(outOfSpecDto.getResult())
                .build();
    }
}

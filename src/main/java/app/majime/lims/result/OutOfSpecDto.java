package app.majime.lims.result;

import lombok.*;

@Getter
@Setter
@Builder
class OutOfSpecDto {
    Long id;
    String name;
    String simple_investigation;
    String complete_investigation;
    String error;
    String value;
    Result result;
}

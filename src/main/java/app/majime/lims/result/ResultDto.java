package app.majime.lims.result;

import app.majime.lims.parameter.ParameterDto;
import app.majime.lims.sample.SampleDto;
import app.majime.lims.user.User;
import app.majime.lims.utils.StatusDeleted;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResultDto {

    Long id;
    String value;
    StatusDeleted deleted;
    ResultStatus status;
    SampleDto sample;
    ParameterDto parameter;
    User user;

}

package app.majime.lims.log;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

@Getter
@Setter
@Builder
class SampleLogDto {

    Long element;
    JsonNode old_row_data;
    JsonNode new_row_data;
    String dml_timestamp;
    String dml_created_by;
    String dml_reason;
}

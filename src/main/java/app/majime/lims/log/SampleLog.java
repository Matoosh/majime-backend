package app.majime.lims.log;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audit_log")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})

class SampleLog {

    @Id
    Long id;

    @Column(name = "tab_name")
    String tabName;

    @Column(name = "element_id")
    Long element;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    JsonNode old_row_data;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    JsonNode new_row_data;

    String dml_timestamp; //timestamp
    String dml_created_by;
    String dml_reason;

    SampleLogDto toDto(){
        return SampleLogDto.builder()
                .element(element)
                .old_row_data(old_row_data)
                .new_row_data(new_row_data)
                .dml_timestamp(dml_timestamp)
                .dml_created_by(dml_created_by)
                .dml_reason(dml_reason)
                .build();
    }

    static  SampleLog buildFrom(SampleLogDto dto){
        return builder()
                .element(dto.element)
                .old_row_data(dto.old_row_data)
                .new_row_data(dto.new_row_data)
                .dml_timestamp(dto.dml_timestamp)
                .dml_created_by(dto.dml_created_by)
                .dml_reason(dto.dml_reason)
                .build();
    }
}

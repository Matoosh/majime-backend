package app.majime.infrastructure.lims.sample.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleDTO {

    private Long id;

    private String sampleNo;

    private int quantity;

    private Long status;
}
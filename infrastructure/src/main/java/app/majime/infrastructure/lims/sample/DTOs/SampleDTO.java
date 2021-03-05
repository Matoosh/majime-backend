package app.majime.infrastructure.lims.sample.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class SampleDTO {

    private Long id;

    private String sampleNo;

    private int quantity;

    private Long status;
}

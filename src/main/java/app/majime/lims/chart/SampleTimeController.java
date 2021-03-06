package app.majime.lims.chart;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SAMPLECHART)
@RequiredArgsConstructor
class SampleTimeController {

    private final SampleTimeService service;

    @GetMapping("/time")
    @PreAuthorize("hasAuthority('USER')")
    List<SampleTimeDto> getSampleTime() {
        return service.getSampleTime().stream()
                .map(SampleTime::toDto)
                .collect(toList());
    }
}

package app.majime.lims.log;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SAMPLELOG)
@RequiredArgsConstructor
class SampleLogController {

    private final SampleLogService service;

    @GetMapping
    List<SampleLogDto> getAll() {return service.findAll().stream().map(SampleLog::toDto).collect(toList());}

    @GetMapping("/{tab_name}/{element}")
    List<SampleLogDto> findByTabNameAndElement(@PathVariable(value = "tab_name") String tab_name, @PathVariable(value = "element") Long element) {
        return service.findByTabNameAndElement(tab_name, element).stream()
                .map(SampleLog::toDto)
                .collect(toList());
    }

    /*
    @GetMapping("/{tab_name}/{id}")
    List<SampleLogDto> getSampleLog(@PathVariable(value = "tab_name") String tab_name, @PathVariable(value = "id") Long id) {
        return service.getSampleLog(tab_name, id).stream()
                .map(SampleLog::toDto)
                .collect(toList());
    }
    */
}

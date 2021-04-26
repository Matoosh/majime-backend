package app.majime.lims.log;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_LOG)
@RequiredArgsConstructor
class LogController {

    private final LogService service;

    @GetMapping
    List<LogDto> getAll() {return service.findAll().stream().map(Log::toDto).collect(toList());}

    @GetMapping("/{tab_name}/{element}")
    List<LogDto> findByTabNameAndElement(@PathVariable(value = "tab_name") String tab_name, @PathVariable(value = "element") Long element) {
        return service.findByTabNameAndElement(tab_name, element).stream()
                .map(Log::toDto)
                .collect(toList());
    }
}

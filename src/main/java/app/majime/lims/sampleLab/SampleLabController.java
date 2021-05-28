package app.majime.lims.sampleLab;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SAMPLE + RestConstants.RESOURCE_LAB)
@RequiredArgsConstructor
class SampleLabController {
    private final SampleLabService service;


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('BATCH_ADOPTION')")
    List<SampleLabDto> findAllBySample(@PathVariable(value = "id") Long id) {
        return service.findAllBySample(id)
                .stream()
                .map(SampleLab::toDto)
                .collect(Collectors.toList());
    }


    @PostMapping
    @PreAuthorize("hasAuthority('BATCH_ADOPTION')")
    ResponseEntity<SampleLabDto> assignSampleToLab(@RequestBody SampleLabDto sampleLabDto) {
        return ok(service.create(SampleLab.buildFrom(sampleLabDto)).toDto());
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('BATCH_ADOPTION')")
    ResponseEntity<SampleLabDto> editSampleToLab(@PathVariable(value = "id") Long id, @RequestBody SampleLabDto sampleLabDto) {
        try {
            SampleLabDto sampleLab = service.update(id, SampleLab.buildFrom(sampleLabDto)).toDto();
            return ok(sampleLab);
        } catch (EntityNotFoundException e) {
            return notFound().build();
        }
    }

}

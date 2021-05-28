package app.majime.lims.sample;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SAMPLE)
@RequiredArgsConstructor
class SampleController {

    private final SampleService sampleService;

    @GetMapping
    @PreAuthorize("hasAuthority('USER') || hasAuthority('SAMPLE') || hasAuthority('BATCH_COLLETION')")
    List<SampleDto> getAll() {
        return sampleService.findAll().stream()
                .map(Sample::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('SAMPLE') || hasAuthority('BATCH_COLLETION')")
    ResponseEntity<SampleDto> getById(@PathVariable(value = "id") Long id) {
        Optional<Sample> sampleOptional = sampleService.findById(id);

        if (sampleOptional.isPresent()) {
            return ok(sampleOptional.get().toDto());
        } else {
            return notFound().build();
        }
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SAMPLE')")
    ResponseEntity<SampleDto> addNewSample(@RequestBody SampleDto sampleDto) {
        if (sampleService.isExist(sampleDto)) {
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        return ok(sampleService.create(Sample.buildFrom(sampleDto)).toDto());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SAMPLE')")
    ResponseEntity<SampleDto> deleteMaterial(@PathVariable(value = "id") Long id) {
        try{
            SampleDto sample = sampleService.deleteSample(id).toDto();;
            return ok(sample);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }

    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('SAMPLE') || hasAuthority('BATCH_COLLETION')")
    ResponseEntity<SampleDto> updateSample(@PathVariable(value = "id") Long id, @RequestBody SampleDto sampleDto) {
        try {
            SampleDto dto = sampleService.updateSample(id, sampleDto).toDto();
            return ok(dto);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

    @PutMapping("/{id}/{status}")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('SAMPLE') || hasAuthority('BATCH_COLLETION')")
    ResponseEntity<SampleDto> updateStatus(@PathVariable(value = "id") Long id, @PathVariable(value = "status") SampleStatus statusCode) {
        try {
            SampleDto sampleDTO = sampleService.updateStatus(id, statusCode).toDto();

            return ok(sampleDTO);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }
}

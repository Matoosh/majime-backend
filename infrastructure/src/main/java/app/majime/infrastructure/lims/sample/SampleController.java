package app.majime.infrastructure.lims.sample;

import app.majime.infrastructure.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static app.majime.infrastructure.lims.sample.SampleNew.buildFrom;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SAMPLE)
@RequiredArgsConstructor
class SampleController {

    private final SampleService sampleService;

    @GetMapping
    List<SampleDto> getAll() {
        return sampleService.findAll().stream()
                .map(SampleNew::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<SampleDto> getById(@PathVariable(value = "id") Long id) {
        Optional<SampleNew> sampleOptional = sampleService.findById(id);

        if (sampleOptional.isPresent()) {
            return ok(sampleOptional.get().toDto());
        } else {
            return notFound().build();
        }
    }

    @PostMapping
    ResponseEntity<SampleDto> addNewSample(@RequestBody SampleDto sampleDto) {
        if (sampleService.isExist(sampleDto)) {
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        return ok(sampleService.create(buildFrom(sampleDto)).toDto());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable(value = "id") Long id) {
        sampleService.deleteById(id);
    }

    @PutMapping("/{id}/{statusCode}")
    ResponseEntity<SampleDto> updateStatus(@PathVariable(value = "id") Long id, @PathVariable(value = "statusCode") Long statusCode) {
        try {
            SampleDto sampleDTO = sampleService.updateStatus(id, statusCode).toDto();

            return ok(sampleDTO);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }
}

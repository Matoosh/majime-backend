package app.majime.infrastructure.lims.sample;

import app.majime.infrastructure.lims.RestConstants;
import app.majime.infrastructure.lims.sample.DTOs.SampleDTO;
import app.majime.infrastructure.lims.sample.services.ISampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SAMPLE)
public class SampleController {

    private final SampleRepository repository;

    @Autowired
    private ISampleService sampleService;

    @Autowired
    public SampleController(SampleRepository sampleRepository) {
        this.repository = sampleRepository;
    }

    @GetMapping()
    public Iterable<SampleDTO> getAll() {
        return sampleService.allSamples();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SampleDTO> getById(@PathVariable(value = "id") Long id) {
        try {
            SampleDTO sampleDTO = sampleService.getById(id);
            return ResponseEntity.ok(sampleDTO);
        } catch (NoSuchElementException notFound) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<SampleDTO> addNewSample(@RequestBody SampleDTO newSampleDTO) {
        if (sampleService.isExist(newSampleDTO))
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        SampleDTO sampleDTO = sampleService.createSample(newSampleDTO);
        return ResponseEntity.ok(sampleDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Sample Not Found", exc);
        }
    }

    @PutMapping("/{id}/{statusCode}")
    public ResponseEntity<SampleDTO> updateStatus(@PathVariable(value = "id") Long id, @PathVariable(value = "statusCode") Long statusCode) {
        try {
            SampleDTO sampleDTO = sampleService.updateStatus(id, statusCode);
            return ResponseEntity.ok(sampleDTO);
        } catch (NoSuchElementException notFound) {
            return ResponseEntity.notFound().build();
        }
    }


}

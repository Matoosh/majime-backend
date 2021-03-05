package app.majime.infrastructure.lims.sample;

import app.majime.core.sample.Sample;
import app.majime.infrastructure.lims.RestConstants;
import app.majime.infrastructure.lims.sample.services.ISampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SAMPLE)
public class SampleController {

    private SampleRepository repository;

    @Autowired
    private ISampleService sampleService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public SampleController(SampleRepository sampleRepository){this.repository = sampleRepository;}

    @GetMapping()
    public Iterable<Sample> getAll() {
//        return repository.findAll();
      return sampleService.allSamples();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sample> getById(@PathVariable(value = "id") Long id){
        Optional<Sample> sample = repository.findById(id);
        if(sample.isPresent()){
            return ResponseEntity.ok(sample.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Sample> addNewSample(@RequestBody Sample newSample){
        Optional<Sample> sampleFromDb = repository.findBySampleNo(newSample.getSampleNo());
        if(sampleFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Sample savedSample = repository.save(newSample);
        return ResponseEntity.ok(savedSample);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Sample Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sample> updateStatus(@PathVariable(value = "id") Long id,@RequestBody Sample newSample){
        Optional<Sample> sampleOptional = repository.findById(id);
        if(sampleOptional.isPresent()){
            Sample sample = sampleOptional.get();
            sample.setStatus(newSample.getStatus());
            repository.save(sample);
            return ResponseEntity.ok(sample);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

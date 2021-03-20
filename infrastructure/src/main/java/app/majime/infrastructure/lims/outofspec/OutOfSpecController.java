package app.majime.infrastructure.lims.outofspec;

import app.majime.core.outOfSpec.OutOfSpec;
import app.majime.infrastructure.lims.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_OUTOFSPEC)
public class OutOfSpecController {

    private OutOfSpecRepository repository;

    @Autowired
    public OutOfSpecController(OutOfSpecRepository outOfSpecRepository) {
        this.repository = outOfSpecRepository;
    }

    @GetMapping()
    public Iterable<OutOfSpec> getAll() {

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutOfSpec> getById(@PathVariable(value = "id") Long id) {
        Optional<OutOfSpec> outOfSpec = repository.findById(id);
        if (outOfSpec.isPresent()) {
            return ResponseEntity.ok(outOfSpec.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<OutOfSpec> addNewOutOfSpec(@RequestBody OutOfSpec newOutOfSpec) {
        Optional<OutOfSpec> outOfSpecFromDb = repository.findById(newOutOfSpec.getId());
        if (outOfSpecFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        OutOfSpec savedOutOfSpec = repository.save(newOutOfSpec);
        return ResponseEntity.ok(savedOutOfSpec);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "OutOfSpec Not Found", exc);
        }
    }

    @PutMapping("/updateError/{id}")
    public ResponseEntity<OutOfSpec> updateError(@PathVariable(value = "id") Long id, @RequestBody OutOfSpec newOutOfSpec) {
        Optional<OutOfSpec> outOfSpecOptional = repository.findById(id);
        if (outOfSpecOptional.isPresent()) {
            OutOfSpec outOfSpec = outOfSpecOptional.get();
            outOfSpec.setError(newOutOfSpec.getError());
            repository.save(outOfSpec);
            return ResponseEntity.ok(outOfSpec);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateValue/{id}")
    public ResponseEntity<OutOfSpec> updateValue(@PathVariable(value = "id") Long id, @RequestBody OutOfSpec newOutOfSpec) {
        Optional<OutOfSpec> outOfSpecOptional = repository.findById(id);
        if (outOfSpecOptional.isPresent()) {
            OutOfSpec outOfSpec = outOfSpecOptional.get();
            outOfSpec.setValue(newOutOfSpec.getValue());
            repository.save(outOfSpec);
            return ResponseEntity.ok(outOfSpec);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


package app.majime.infrastructure.lims.batch;


import app.majime.infrastructure.lims.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_BATCH)

public class BatchController {
    private BatchRepository repository;

    @Autowired
    public BatchController(BatchRepository batchRepository) {
        this.repository = batchRepository;
    }

    @GetMapping()
    public Iterable<Batch> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Batch> getById(@PathVariable(value = "id") Long id) {
        Optional<Batch> batch = repository.findById(id);
        if (batch.isPresent()) {
            return ResponseEntity.ok(batch.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Batch> addNewBatch(@RequestBody Batch newBatch) {
        Optional<Batch> batchFromDb = repository.findById(newBatch.getId());
        if (batchFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Batch savedBatch = repository.save(newBatch);
        return ResponseEntity.ok(savedBatch);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Batch Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Batch> updateDeleted(@PathVariable(value = "id") Long id, @RequestBody Batch newBatch) {
        Optional<Batch> batchOptional = repository.findById(id);
        if (batchOptional.isPresent()) {
            Batch batch = batchOptional.get();
            batch.setDeleted(newBatch.getDeleted());
            repository.save(batch);
            return ResponseEntity.ok(batch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package app.majime.infrastructure.lims.lab.controllers;

import app.majime.core.lab.Lab;
import app.majime.infrastructure.lims.constants.RestConstants;
import app.majime.infrastructure.lims.lab.repositories.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_LAB)

public class LabController {
    private LabRepository repository;

    @Autowired
    public LabController(LabRepository labRepository) {
        this.repository = labRepository;
    }

    @GetMapping()
    public Iterable<Lab> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lab> getById(@PathVariable(value = "id") Long id) {
        Optional<Lab> lab = repository.findById(id);
        if (lab.isPresent()) {
            return ResponseEntity.ok(lab.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Lab> addNewLab(@RequestBody Lab newLab) {
        Optional<Lab> labFromDb = repository.findByName(newLab.getName());
        if (labFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Lab savedLab = repository.save(newLab);
        return ResponseEntity.ok(savedLab);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Lab Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lab> updateDeleted(@PathVariable(value = "id") Long id, @RequestBody Lab newLab) {
        Optional<Lab> labOptional = repository.findById(id);
        if (labOptional.isPresent()) {
            Lab lab = labOptional.get();
            lab.setDeleted(newLab.getDeleted());
            repository.save(lab);
            return ResponseEntity.ok(lab);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

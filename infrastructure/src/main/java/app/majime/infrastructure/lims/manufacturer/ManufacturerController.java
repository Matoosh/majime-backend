package app.majime.infrastructure.lims.manufacturer;
import app.majime.core.manufacturer.Manufacturer;
import app.majime.infrastructure.lims.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_MANUFACTURER)
public class ManufacturerController {

    private ManufacturerRepository repository;

    @Autowired
    public ManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.repository = manufacturerRepository;
    }

    @GetMapping()
    public Iterable<Manufacturer> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getById(@PathVariable(value = "id") Long id) {
        Optional<Manufacturer> manufacturer = repository.findById(id);
        if (manufacturer.isPresent()) {
            return ResponseEntity.ok(manufacturer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Manufacturer> addNewManufacturer(@RequestBody Manufacturer newManufacturer) {
        Optional<Manufacturer> manufacturerFromDb = repository.findByName(newManufacturer.getName());
        if (manufacturerFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Manufacturer savedManufacturer = repository.save(newManufacturer);
        return ResponseEntity.ok(savedManufacturer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Manufacturer Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> updateDeleted(@PathVariable(value = "id") Long id, @RequestBody Manufacturer newManufacturer) {
        Optional<Manufacturer> manufacturerOptional = repository.findById(id);
        if (manufacturerOptional.isPresent()) {
            Manufacturer manufacturer = manufacturerOptional.get();
            manufacturer.setDeleted(newManufacturer.getDeleted());
            repository.save(manufacturer);
            return ResponseEntity.ok(manufacturer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

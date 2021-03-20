package app.majime.infrastructure.lims.supplier;

import app.majime.infrastructure.lims.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SUPPLIER)

public class SupplierController {
    private SupplierRepository repository;

    @Autowired
    public SupplierController(SupplierRepository supplierRepository) {
        this.repository = supplierRepository;
    }

    @GetMapping()
    public Iterable<Supplier> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable(value = "id") Long id) {
        Optional<Supplier> supplier = repository.findById(id);
        if (supplier.isPresent()) {
            return ResponseEntity.ok(supplier.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Supplier> addNewSupplier(@RequestBody Supplier newSupplier) {
        Optional<Supplier> supplierFromDb = repository.findById(newSupplier.getId());
        if (supplierFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Supplier savedSupplier = repository.save(newSupplier);
        return ResponseEntity.ok(savedSupplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Supplier Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateDeleted(@PathVariable(value = "id") Long id, @RequestBody Supplier newSupplier) {
        Optional<Supplier> supplierOptional = repository.findById(id);
        if (supplierOptional.isPresent()) {
            Supplier supplier = supplierOptional.get();
            supplier.setDeleted(newSupplier.getDeleted());
            repository.save(supplier);
            return ResponseEntity.ok(supplier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

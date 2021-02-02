package app.majime.infrastructure.lims.material.controllers;

import app.majime.core.material.Material;
import app.majime.infrastructure.lims.constants.RestConstants;
import app.majime.infrastructure.lims.material.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_MATERIAL)
public class MaterialController {

    private MaterialRepository repository;

    @Autowired
    public MaterialController(MaterialRepository materialRepository) {
        this.repository = materialRepository;
    }

    @GetMapping()
    public Iterable<Material> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getById(@PathVariable(value = "id") Long id) {
        Optional<Material> material = repository.findById(id);
        if (material.isPresent()) {
            return ResponseEntity.ok(material.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Material> addNewMaterial(@RequestBody Material newMaterial) {
        Optional<Material> materialFromDb = repository.findByName(newMaterial.getName());
        if (materialFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Material savedMaterial = repository.save(newMaterial);
        return ResponseEntity.ok(savedMaterial);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Material Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateName(@PathVariable(value = "id") Long id, @RequestBody Material newMaterial) {
        Optional<Material> materialOptional = repository.findById(id);
        if (materialOptional.isPresent()) {
            Material material = materialOptional.get();
            material.setName(newMaterial.getName());
            repository.save(material);
            return ResponseEntity.ok(material);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

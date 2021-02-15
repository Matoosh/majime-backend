package app.majime.infrastructure.lims.specification.controllers;

import app.majime.core.specification.Specification;
import app.majime.infrastructure.lims.constants.RestConstants;
import app.majime.infrastructure.lims.specification.repositories.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SPECIFICATION)
public class SpecificationController {

    private SpecificationRepository repository;

    @Autowired
    public SpecificationController(SpecificationRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public Iterable<Specification> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specification> getById(@PathVariable(value = "id") Long id) {
        Optional<Specification> specFromDb = repository.findById(id);
        return specFromDb.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

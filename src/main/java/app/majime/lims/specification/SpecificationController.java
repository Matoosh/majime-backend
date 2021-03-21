package app.majime.lims.specification;

import app.majime.lims.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SPECIFICATION)
class SpecificationController {

    private SpecificationRepository repository;

    @Autowired
    SpecificationController(SpecificationRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    Iterable<Specification> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Specification> getById(@PathVariable(value = "id") Long id) {
        Optional<Specification> specFromDb = repository.findById(id);
        return specFromDb.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

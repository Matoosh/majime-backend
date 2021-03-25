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

    private SpecificationRepository specificationRepository;
    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    SpecificationController(SpecificationRepository repository,MaterialRepository materialRepository) {
        this.specificationRepository = repository;
        this.materialRepository = materialRepository;
    }

    @GetMapping()
    Iterable<Specification> getAll() {
        return specificationRepository.findAll();
    }

    @GetMapping("/materials")
    Iterable<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Specification> getById(@PathVariable(value = "id") Long id) {
        Optional<Specification> specFromDb = specificationRepository.findById(id);
        return specFromDb.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

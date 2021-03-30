package app.majime.lims.specification;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SPECIFICATION)
class SpecificationController {

    private final SpecificationService specificationService;

    @GetMapping
    List<SpecificationDto> getAll() {
       // return specificationService.findAll();
        return specificationService.findAll().stream()
                .map(Specification::toDto)
                .collect(toList());
    }

    @GetMapping("/material")
    List<Material> getAllMaterials() {
        return specificationService.findAllMaterials();
//        return specificationService.findAll().stream()
//                .map(Specification::toDto)
//                .collect(toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<SpecificationDto> getById(@PathVariable(value = "id") Long id) {
        Optional<Specification> specificationOptional = specificationService.findById(id);
        if (specificationOptional.isPresent()) {
            return ok(specificationOptional.get().toDto());
        } else {
            return notFound().build();
        }
    }

    @GetMapping("/material/{id}")
    List<SpecificationDto> getByMaterialId(@PathVariable(value = "id") Long id) {
        Optional<Material> materialOptional = specificationService.findMaterialById(id);
        if (materialOptional.isPresent()) {
            List<Specification> specificationList = specificationService.findByMaterialId(id);
            return specificationList.stream().map(Specification::toDto).collect(toList());
        } else {
            return null;
        }
    }

    @PostMapping()
    ResponseEntity<SpecificationDto> addNewSpecification(@RequestBody SpecificationDto specificationDto) {
        if (specificationService.isExist(specificationDto)) {
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        return ok(specificationService.create(Specification.buildFrom(specificationDto)).toDto());
    }

    @PostMapping("/material")
    ResponseEntity<MaterialDto> addNewMaterial(@RequestBody MaterialDto materialDto) {
//        if (specificationService.isExist(specificationDto)) {
//            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//        }
        return ok(specificationService.createMaterial(Material.buildFrom(materialDto)).toDto());
    }

    // @TODO should post "deleted" to 'true'
    @DeleteMapping("/{id}")
    void delete(@PathVariable(value = "id") Long id, @RequestBody SpecificationDto specificationDto) {
        specificationService.deleteById(id);
    }

    @PutMapping("/{id}/{status}")
    ResponseEntity<SpecificationDto> updateSpecificationStatus(@PathVariable(value = "id") Long id, @PathVariable(value = "status") SpecificationStatus statusCode) {
        try{
            SpecificationDto specification = specificationService.updateSpecificationStatus(id, statusCode).toDto();
            return ok(specification);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }
}

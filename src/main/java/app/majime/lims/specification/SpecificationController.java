package app.majime.lims.specification;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SPECIFICATION)
class SpecificationController {

    private final SpecificationService specificationService;

    @GetMapping
    @PreAuthorize("hasAuthority('SAMPLE') || hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    List<SpecificationDto> getAll() {
        return specificationService.findAll().stream()
                .map(Specification::toDto)
                .collect(toList());
    }

    @GetMapping("/material")
    @PreAuthorize("hasAuthority('SAMPLE') || hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    List<MaterialDto> getAllMaterials() {
        return specificationService.findAllMaterials().stream()
                .map(Material::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SAMPLE') || hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    ResponseEntity<SpecificationDto> getById(@PathVariable(value = "id") Long id) {
        Optional<Specification> specificationOptional = Optional.ofNullable(specificationService.findById(id));
        if (specificationOptional.isPresent()) {
            return ok(specificationOptional.get().toDto());
        } else {
            return notFound().build();
        }
    }

    @GetMapping("/material/{id}")
    @PreAuthorize("hasAuthority('SAMPLE') || hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
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
    @PreAuthorize("hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    ResponseEntity<SpecificationDto> addNewSpecification(@RequestBody SpecificationDto specificationDto) {
        return ok(specificationService.create(Specification.buildFrom(specificationDto)).toDto());
    }

    @PostMapping("/material")
    @PreAuthorize("hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    ResponseEntity<MaterialDto> addNewMaterial(@RequestBody MaterialDto materialDto) {
        return ok(specificationService.createMaterial(Material.buildFrom(materialDto)).toDto());
    }


    // @TODO should PUT "deleted" to 'true'
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    ResponseEntity<SpecificationDto> deleteSpecification(@PathVariable(value = "id") Long id) {
        try{
            SpecificationDto specification = specificationService.deleteSpecification(id).toDto();;
            return ok(specification);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    ResponseEntity<SpecificationDto> updateSpecification(@PathVariable(value = "id") Long id, @RequestBody SpecificationDto specificationDto) {
        try{
            SpecificationDto specification = specificationService.updateSpecification(id, specificationDto).toDto();
            return ok(specification);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }


    @PutMapping("/{id}/{status}")
    @PreAuthorize("hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    ResponseEntity<SpecificationDto> updateSpecificationStatus(@PathVariable(value = "id") Long id, @PathVariable(value = "status") SpecificationStatus statusCode) {
        try{
            SpecificationDto specification = specificationService.updateSpecificationStatus(id).toDto();
            return ok(specification);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

    @PutMapping("/material/{id}")
    @PreAuthorize("hasAuthority('SAMPLE') || hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    ResponseEntity<MaterialDto> updateMaterial(@PathVariable(value = "id") Long id, @RequestBody MaterialDto materialDto) {
        try{
            MaterialDto material = specificationService.updateMaterial(id,Material.buildFrom(materialDto)).toDto();
            return ok(material);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

    @DeleteMapping("/material/{id}")
    @PreAuthorize("hasAuthority('SPECIFICATION') || hasAuthority('REPORTS')")
    ResponseEntity<MaterialDto> deleteMaterial(@PathVariable(value = "id") Long id) {
        try{
            MaterialDto material = specificationService.deleteMaterial(id).toDto();;
            return ok(material);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }

    }
}

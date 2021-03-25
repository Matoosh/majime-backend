package app.majime.lims.specification;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    List<Specification> getAll() {
        return specificationService.findAll();
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

    @PostMapping()
    ResponseEntity<SpecificationDto> addNewSpecification(@RequestBody SpecificationDto specificationDto) {
        if (specificationService.isExist(specificationDto)) {
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        return ok(specificationService.create(Specification.buildFrom(specificationDto)).toDto());
    }

    // @TODO should post "deleted" to 'true'
//    @DeleteMapping("/{id}")
//    ResponseEntity<SpecificationDto> delete(@PathVariable(value = "id") Long id, @RequestBody SpecificationDto specificationDto) {
//
//    }

    @PutMapping("/{id}")
    ResponseEntity<SpecificationDto> updateSpecification(@PathVariable(value = "id") Long id, @RequestBody SpecificationDto specificationDto) {
        try{
            SpecificationDto specification = specificationService.updateSpecification(id, specificationDto).toDto();
            return ok(specification);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }
}

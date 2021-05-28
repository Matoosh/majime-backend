package app.majime.lims.lab;

import app.majime.lims.RestConstants;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Embeddable;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_LAB)
@RequiredArgsConstructor
class LabController {

    private final LabService labService;

    @GetMapping
    @PreAuthorize("hasAuthority('LAB') || hasAuthority('ADMIN') || hasAuthority('BATCH_ADOPTION')")
    List<LabDto> getAll() {
        return labService.findAll().stream()
                .map(Lab::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('LAB') || hasAuthority('ADMIN') || hasAuthority('BATCH_ADOPTION')")
    ResponseEntity<LabDto> getById(@PathVariable(value = "id") Long id) {
        Optional<Lab> labOptional = labService.findById(id);
        if (labOptional.isPresent()) {
            return ok(labOptional.get().toDto());
        } else {
            return notFound().build();
        }
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('LAB')")
    ResponseEntity<LabDto> addNewLab(@RequestBody LabDto labDto) {
        return ok(labService.create(Lab.buildFrom(labDto)).toDto());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('LAB')")
    void delete(@PathVariable(value = "id") Long id) {labService.deleteById(id);}

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('LAB')")
    ResponseEntity<LabDto> updateLab(@PathVariable(value = "id") Long id, @RequestBody LabDto labDto) {
        try{
            LabDto dto = labService.updateLab(id, labDto).toDto();
            return ok(dto);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }
    
}

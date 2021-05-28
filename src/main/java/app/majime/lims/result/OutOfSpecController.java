package app.majime.lims.result;

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
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_OOS)
class OutOfSpecController {
    private final OutOfSpecService outOfSpecService;

    @GetMapping()
    List<OutOfSpecDto> getAll(){
        return outOfSpecService
                .findAll()
                .stream()
                .map(OutOfSpec::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<OutOfSpecDto> getById(@PathVariable(value = "id") Long id) {
        Optional<OutOfSpec> outOfSpecOptional = outOfSpecService.findById(id);
        if(outOfSpecOptional.isPresent()){
            return ok(outOfSpecOptional.get().toDto());
        } else {
            return notFound().build();
        }
    }

    @GetMapping("/result/{id}")
    ResponseEntity<OutOfSpecDto> getOutOfSpecByResultId(@PathVariable(value = "id") Long id) {
        try {
            return ok(outOfSpecService.findByResultId(id).toDto());
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('OOS')")
    ResponseEntity<OutOfSpecDto> addNew(@RequestBody OutOfSpecDto outOfSpecDto) {
        return ok(outOfSpecService.create(OutOfSpec.buildFrom(outOfSpecDto)).toDto());
    }

    @PutMapping("/{id}")
    ResponseEntity<OutOfSpecDto> updateResult(@PathVariable(value = "id") Long id, @RequestBody OutOfSpecDto outOfSpecDto) {
        try{
            OutOfSpecDto result = outOfSpecService.update(id, outOfSpecDto).toDto();
            return ok(result);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

}

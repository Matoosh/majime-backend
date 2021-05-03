package app.majime.lims.parameter;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_PARAMETER)
class ParameterController {

    private final ParameterService parameterService;

    @GetMapping()
    List<ParameterDto> getAll() {
        return parameterService.findAll().stream()
                .map(Parameter::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<ParameterDto> getById(@PathVariable(value = "id") Long id){
        Optional<Parameter> parameterOptional = parameterService.findById(id);
        if(parameterOptional.isPresent()){
            return ResponseEntity.ok(parameterOptional.get().toDto());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<ParameterDto> addNewParameter(@RequestBody ParameterDto newParameter){
//        Optional<Parameter> parameterFromDb = repository.findByName(newParameter.getName());
//        if(parameterFromDb.isPresent()) {
//            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//        }
//        Parameter savedParameter = repository.save(newParameter);
        return ok(parameterService.create(Parameter.buildFrom(newParameter)).toDto());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ParameterDto> deleteParameter(@PathVariable(value = "id") Long id) {
        try{
            ParameterDto parameter = parameterService.deleteParameter(id).toDto();;
            return ok(parameter);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }

    }

    @GetMapping("/spec/{id}")
    List<ParameterDto> getParameterBySpecificationId(@PathVariable(value = "id") Long id) {
        List <Parameter> parametersList = parameterService.findBySpecificationId(id);
        return parametersList
                .stream()
                .map(Parameter::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/parameter/{id}")
    ResponseEntity<ParameterDto> updateParameter(@PathVariable(value = "id") Long id, @RequestBody ParameterDto parameterDto) {
        try{
            ParameterDto parameter = parameterService.updateParameter(id, parameterDto).toDto();
            return ok(parameter);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

/*
    @PutMapping("/border/{id}")
    ResponseEntity<Parameter> updateStatus(@PathVariable(value = "id") Long id,@RequestBody Parameter newParameter){
        Optional<Parameter> parameterOptional = repository.findById(id);
        if(parameterOptional.isPresent()){
            Parameter parameter = parameterOptional.get();
            parameter.setBorder(newParameter.getBorder());
            repository.save(parameter);
            return ResponseEntity.ok(parameter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/type/{id}")
    ResponseEntity<Parameter> updateType(@PathVariable(value = "id") Long id,@RequestBody Parameter newParameter){
        Optional<Parameter> parameterOptional = repository.findById(id);
        if(parameterOptional.isPresent()){
            Parameter parameter = parameterOptional.get();
            parameter.setType(newParameter.getType());
            repository.save(parameter);
            return ResponseEntity.ok(parameter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 */
}

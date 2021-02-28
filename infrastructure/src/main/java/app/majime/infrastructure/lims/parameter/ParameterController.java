package app.majime.infrastructure.lims.parameter;

import app.majime.core.parameter.Parameter;
import app.majime.infrastructure.lims.RestConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_PARAMETER)
public class ParameterController {

    private ParameterRepository repository;

    @Autowired
    public ParameterController(ParameterRepository parametersRepository){
        this.repository = parametersRepository;}

    @GetMapping()
    public Iterable<Parameter> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parameter> getById(@PathVariable(value = "id") Long id){
        Optional<Parameter> parameter = repository.findById(id);
        if(parameter.isPresent()){
            return ResponseEntity.ok(parameter.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Parameter> addNewParameter(@RequestBody Parameter newParameter){
        Optional<Parameter> parameterFromDb = repository.findByName(newParameter.getName());
        if(parameterFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Parameter savedParameter = repository.save(newParameter);
        return ResponseEntity.ok(savedParameter);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Parameter Not Found", exc);
        }
    }

    @PutMapping("/border/{id}")
    public ResponseEntity<Parameter> updateStatus(@PathVariable(value = "id") Long id,@RequestBody Parameter newParameter){
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
    public ResponseEntity<Parameter> updateType(@PathVariable(value = "id") Long id,@RequestBody Parameter newParameter){
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
}

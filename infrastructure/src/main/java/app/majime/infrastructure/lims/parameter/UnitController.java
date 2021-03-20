package app.majime.infrastructure.lims.parameter;

import app.majime.infrastructure.lims.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_UNIT)
public class UnitController {

    private UnitRepository repository;

    @Autowired
    public UnitController(UnitRepository unitRepository){
        this.repository = unitRepository;}

    @GetMapping()
    public Iterable<Unit> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> getById(@PathVariable(value = "id") Long id){
        Optional<Unit> unit = repository.findById(id);
        if(unit.isPresent()){
            return ResponseEntity.ok(unit.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Unit> addNewUnit(@RequestBody Unit newUnit){
        Optional<Unit> unitFromDb = repository.findById(newUnit.getId());
        if(unitFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Unit savedUnit = repository.save(newUnit);
        return ResponseEntity.ok(savedUnit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Unit Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unit> updateValue(@PathVariable(value = "id") Long id,@RequestBody Unit newUnit){
        Optional<Unit> unitOptional = repository.findById(id);
        if(unitOptional.isPresent()){
            Unit unit = unitOptional.get();
            unit.setValue(newUnit.getValue());
            repository.save(unit);
            return ResponseEntity.ok(unit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

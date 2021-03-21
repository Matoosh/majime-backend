package app.majime.lims.result;

import app.majime.lims.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_RESULT)
class ResultController {

    private ResultRepository repository;

    @Autowired
    ResultController(ResultRepository resultRepository){
        this.repository = resultRepository;}

    @GetMapping()
    Iterable<Result> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Result> getById(@PathVariable(value = "id") Long id){
        Optional<Result> result = repository.findById(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<Result> addNewResult(@RequestBody Result newResult){
        Optional<Result> resultFromDb = repository.findById(newResult.getId());
        if(resultFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Result savedResult = repository.save(newResult);
        return ResponseEntity.ok(savedResult);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable(value = "id") Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Result Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Result> updateStatus(@PathVariable(value = "id") Long id,@RequestBody Result newResult){
        Optional<Result> resultOptional = repository.findById(id);
        if(resultOptional.isPresent()){
            Result result = resultOptional.get();
            //TODO make updateStatus (by using Dictonary as relation definied in Result class).
//            result.setStatus(newResult.getStatus());
            repository.save(result);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

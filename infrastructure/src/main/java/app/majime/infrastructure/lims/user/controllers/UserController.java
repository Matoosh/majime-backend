package app.majime.infrastructure.lims.user.controllers;

import app.majime.core.sample.Sample;
import app.majime.core.user.User;
import app.majime.infrastructure.lims.constants.RestConstants;
import app.majime.infrastructure.lims.sample.controllers.SampleController;
import app.majime.infrastructure.lims.sample.repositories.SampleRepository;
import app.majime.infrastructure.lims.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_USER)
public class UserController {

    private UserRepository repository;
    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    public UserController(UserRepository userRepository){this.repository = userRepository;}

    @GetMapping()
    public Iterable<User> getAll() {return repository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable(value = "id") Long id){
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<User> addNewUser(@RequestBody User newUser){
        Optional<User> userFromDb = repository.findByEmail(newUser.getEmail());
        if(userFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        User savedUser = repository.save(newUser);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,@RequestBody User newUser){
        Optional<User> userOptional = repository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            repository.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/sample/{sampleId}")
    public ResponseEntity<User> addSampleToUser(@PathVariable(value = "id") Long id,@PathVariable(value = "id") Long sampleId){
        Optional<User> userOptional = repository.findById(id);
        Optional<Sample> sample = sampleRepository.findById(sampleId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Set<Sample> samples = userOptional.get().getSamples();
            samples.add(sample.get());
            user.setSamples(samples);
            repository.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

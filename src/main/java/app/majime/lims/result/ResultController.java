package app.majime.lims.result;

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
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_RESULT)
class ResultController {

    private ResultService resultService;

    @GetMapping()
    List<ResultDto> getAll() {
        return resultService.findAll().stream()
                .map(Result::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<ResultDto> getById(@PathVariable(value = "id") Long id){
        Optional<Result> resultOptional = resultService.findById(id);
        if(resultOptional.isPresent()){
            return ok(resultOptional.get().toDto());
        }else{
            return notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<ResultDto> addNewResult(@RequestBody ResultDto resultDto) {
        return ok(resultService.create(Result.buildFrom(resultDto)).toDto());
    }
//    ResponseEntity<Result> addNewResult(@RequestBody ResultDto newResultDto){
//        Optional<Result> resultFromDb = repository.findById(newResult.getId());
//        if(resultFromDb.isPresent()) {
//            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//        }
//        Result savedResult = repository.save(newResult);
//        return ok(savedResult);
//    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResultDto> deleteResult(@PathVariable(value = "id") Long id) {
        try{
            ResultDto result = resultService.deleteResult(id).toDto();;
            return ok(result);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<ResultDto> updateResult(@PathVariable(value = "id") Long id, @RequestBody ResultDto resultDto) {
        try{
            ResultDto result = resultService.updateResult(id, resultDto).toDto();
            return ok(result);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }

    @GetMapping("/result/{id}")
    List<ResultDto> getResultBySampleId(@PathVariable(value = "id") Long id) {
        List <Result> resultList = resultService.findBySampleId(id);
        return resultList
                .stream()
                .map(Result::toDto)
                .collect(Collectors.toList());
    }

}

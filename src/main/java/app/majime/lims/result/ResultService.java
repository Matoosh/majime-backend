package app.majime.lims.result;

import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ResultService {

    private final ResultRepository resultRepository;

    List<Result> findAll() {
        return resultRepository.findAll();
    }

    Optional<Result> findById(Long id) {
        return resultRepository.findById(id);
    }

    Result create(Result result) {
        result.setDeleted(StatusDeleted.FALSE);
        result.setStatus(ResultStatus.NEW);
        return resultRepository.save(result);
    }

    Result updateResult(Long id, ResultDto resultDto) throws EntityNotFoundException {
        Optional<Result> resultOptional = resultRepository.findById(id);

        if (!resultOptional.isPresent()){
            throw new EntityNotFoundException("Not found result id = " + id);
        }
        Result result = resultOptional.get();
        result = result.buildFrom(resultDto);
        return resultRepository.save(result);
    }

    Result approveResultStatus(Long id) throws EntityNotFoundException {
        Optional<Result> resultOptional = resultRepository.findById(id);

        if (resultOptional.isPresent()) {
            Result result = resultOptional.get();
            result.setStatus(ResultStatus.APPROVED);
            return resultRepository.save(result);
        }
        throw new EntityNotFoundException("Not found Result id = " + id);
    }

    Result deleteResult(Long id) throws EntityNotFoundException {
        Optional<Result> resultOptional = resultRepository.findById(id);

        if (resultOptional.isPresent()){
            Result resultDb = resultOptional.get();
            resultDb.setDeleted(StatusDeleted.TRUE);
            return resultRepository.save(resultDb);
        }
        throw new EntityNotFoundException("Not found Result id = " + id);
    }

    List<Result> findBySampleId(Long id){
        return resultRepository.findAll()
                .stream().filter(result -> (result.getSample().getId() == id))
                .collect(Collectors.toList());
    }

}

package app.majime.lims.result;

import app.majime.lims.exception.CustomException;
import app.majime.lims.parameter.ParameterService;
import app.majime.lims.sample.Sample;
import app.majime.lims.sample.SampleRepository;
import app.majime.lims.sample.SampleStatus;
import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ResultService {

    private final ResultRepository resultRepository;
    private final SampleRepository sampleRepository;
    private final ParameterService parameterService;

    List<Result> findAll() {
        return resultRepository.findAll();
    }

    Optional<Result> findById(Long id) {
        return resultRepository.findById(id);
    }

    Result create(Result result) {
        result.setDeleted(StatusDeleted.FALSE);
        Sample sample = result.getSample();
        if (result.getStatus() == ResultStatus.OOS && sample.getStatus() != SampleStatus.OOS) {
            sample.setDeleted(StatusDeleted.FALSE);
            sample.setStatus(SampleStatus.OOS);
            try {
                sampleRepository.save(sample);
            } catch (CustomException customException){
                throw new CustomException("Error with change status in sample", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        checkAllResultsFiled(result);
        return resultRepository.save(result);
    }

    Result updateResult(Long id, ResultDto resultDto) throws EntityNotFoundException {
        Optional<Result> resultOptional = resultRepository.findById(id);

        if (!resultOptional.isPresent()){
            throw new EntityNotFoundException("Not found result id = " + id);
        }
        Result result = resultOptional.get();
        result = result.buildFrom(resultDto);
        Sample sample = result.getSample();
        if (result.getStatus() == ResultStatus.OOS && sample.getStatus() != SampleStatus.OOS) {
            sample.setDeleted(StatusDeleted.FALSE);
            sample.setStatus(SampleStatus.OOS);
            try {
                sampleRepository.save(sample);
            } catch (CustomException customException){
                throw new CustomException("Error with change status in sample", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        checkAllResultsFiled(result);
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

    Result updateStatus (Long id, ResultStatus status) throws EntityNotFoundException{
        Optional<Result> resultOptional = resultRepository.findById(id);
        if(resultOptional.isPresent()){
            Result result = resultOptional.get();
            result.setStatus(status);
            return  resultRepository.save(result);
        }
        throw new EntityNotFoundException("Result not found: " + id);
    }

    void checkAllResultsFiled(Result result) throws EntityNotFoundException{
        int numberOfResults = findBySampleId(result.getSample().getId()).stream()
                .filter(resultOb -> resultOb.getStatus() == ResultStatus.OOSADDED || resultOb.getStatus() == ResultStatus.ENTERED)
                .collect(Collectors.toList()).size()
                + ((result.getId() == null && result.getStatus() == ResultStatus.ENTERED) ? 1 : 0);
        int numberOfParameters = parameterService.findBySpecificationId(result.getParameter().getSpecification().getId())
                .stream().filter(parameter -> (parameter.getSpecification().getId() == result.getSample().getSpecification().getId()))
                .collect(Collectors.toList()).size();
        if(numberOfResults == numberOfParameters){
            Sample sample = result.getSample();
            sample.setDeleted(StatusDeleted.FALSE);
            sample.setStatus(SampleStatus.CHECK);
            try {
                sampleRepository.save(sample);
            } catch (CustomException customException){
                throw new CustomException("Error with change status in sample", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
    }
}

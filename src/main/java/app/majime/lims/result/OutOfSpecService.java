package app.majime.lims.result;

import app.majime.lims.exception.CustomException;
import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class OutOfSpecService {
    private final OutOfSpecRepository outOfSpecRepository;
    private final ResultRepository resultRepository;
    private final ResultService resultService;

    List<OutOfSpec> findAll() {return outOfSpecRepository.findAll();}

    Optional<OutOfSpec> findById(Long id) {return outOfSpecRepository.findById(id);}

    OutOfSpec create(OutOfSpec outOfSpec) {
        outOfSpec.setDeleted(StatusDeleted.FALSE);
        Result result = outOfSpec.getResult();
        result.setStatus(ResultStatus.OOSADDED);
        result.setValue(outOfSpec.getValue());
        try {
            resultRepository.save(result);
        } catch (CustomException customException){
            throw new CustomException("Error with change status in result", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        resultService.checkAllResultsFilled(result);
        return outOfSpecRepository.save(outOfSpec);
    }

    OutOfSpec update(Long id, OutOfSpecDto outOfSpecDto) throws EntityNotFoundException {
        Optional<OutOfSpec> oOSOptional = outOfSpecRepository.findById(id);

        if (!oOSOptional.isPresent()){
            throw new EntityNotFoundException("Not found result id = " + id);
        }
        OutOfSpec oOS = oOSOptional.get();
        oOS.setComplete_investigation(outOfSpecDto.getComplete_investigation());
        oOS.setSimple_investigation(outOfSpecDto.getSimple_investigation());
        oOS.setError(outOfSpecDto.getError());
        oOS.setValue(outOfSpecDto.getValue());
        Result result = oOS.getResult();
        result.setValue(oOS.getValue());
        try {
            resultRepository.save(result);
        } catch (CustomException customException){
            throw new CustomException("Error with change status in result", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        resultService.checkAllResultsFilled(result);
        return outOfSpecRepository.save(oOS);
    }

    OutOfSpec findByResultId(Long id) throws EntityNotFoundException{
        Optional<OutOfSpec> oOSOptional = outOfSpecRepository.findByResultId(id);

        if (!oOSOptional.isPresent()){
            throw new EntityNotFoundException("Not found result id = " + id);
        }
        return oOSOptional.get();
    }
}

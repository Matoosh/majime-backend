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
    //TODO check repository
    private final ResultRepository resultRepository;

    List<OutOfSpec> findAll() {return outOfSpecRepository.findAll();}

    Optional<OutOfSpec> findById(Long id) {return outOfSpecRepository.findById(id);}

    OutOfSpec create(OutOfSpec outOfSpec) {
        outOfSpec.setDeleted(StatusDeleted.FALSE);
        Result result = outOfSpec.getResult();
        result.setStatus(ResultStatus.OOSADDED);
        try {
            resultRepository.save(result);
        } catch (CustomException customException){
            throw new CustomException("Error with change status in result", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return outOfSpecRepository.save(outOfSpec);
    }

    OutOfSpec update(Long id, OutOfSpecDto outOfSpecDto) throws EntityNotFoundException {
        Optional<OutOfSpec> oOSOptional = outOfSpecRepository.findById(id);

        if (!oOSOptional.isPresent()){
            throw new EntityNotFoundException("Not found result id = " + id);
        }
        OutOfSpec oOS = oOSOptional.get();
        oOS = oOS.buildFrom(outOfSpecDto);
        //oOS.setDeleted(StatusDeleted.FALSE);
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

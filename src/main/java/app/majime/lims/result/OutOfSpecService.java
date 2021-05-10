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
class OutOfSpecService {
    private final OutOfSpecRepository outOfSpecRepository;

    List<OutOfSpec> findAll() {return outOfSpecRepository.findAll();}

    Optional<OutOfSpec> findById(Long id) {return outOfSpecRepository.findById(id);}

    OutOfSpec create(OutOfSpec outOfSpec) {
        outOfSpec.setDeleted(StatusDeleted.FALSE);
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

    List<OutOfSpec> findByResultId(Long id){
        return outOfSpecRepository.findAll()
                .stream().filter(res ->(res.getResult().getId() == id))
                .collect(Collectors.toList());
    }
}

package app.majime.lims.result;

import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}

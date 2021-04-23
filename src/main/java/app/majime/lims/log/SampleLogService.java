package app.majime.lims.log;

import app.majime.lims.address.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SampleLogService {

    private final SampleLogRepository repository;

    List<SampleLog> findAll() {return repository.findAll();}

    //Optional<SampleLog> findById(Long id) {return repository.findById(id);}

    List<SampleLog> findByTabNameAndElement(String tab_name, Long element) {
        return repository.findByTabNameAndElement(tab_name, element);
    };

    //List<SampleLog> getSampleLog(String tab_name, Long id){return repository.getSampleLog(tab_name, id);}
    //Optional<SampleLog> getSampleLog(String tab_name, Long id){return repository.getSampleLog(tab_name, id);}
}

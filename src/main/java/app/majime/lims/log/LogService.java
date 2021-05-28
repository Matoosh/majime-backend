package app.majime.lims.log;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class LogService {

    private final LogRepository repository;

    List<Log> findAll() {return repository.findAll();}

    List<Log> findByTabNameAndElement(String tab_name, Long element) {
        return repository.findByTabNameAndElement(tab_name, element);
    }
}

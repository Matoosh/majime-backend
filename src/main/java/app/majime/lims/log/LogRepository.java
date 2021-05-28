package app.majime.lims.log;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByTabNameAndElement(String tab_name, Long element);
}

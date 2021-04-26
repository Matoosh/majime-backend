package app.majime.lims.chart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SampleTimeService {

    private final SampleTimeRepository repository;

    //List<SampleTime> getSampleTime(){return repository.getSampleTime();}
    //List<String> getSampleWynik(){return repository.getSampleWynik();}
    List<SampleTime> getSampleWynik(){return repository.getSampleWynik();}
}

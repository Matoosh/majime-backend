package app.majime.infrastructure.lims.sample.services;

import app.majime.core.sample.Sample;
import app.majime.infrastructure.lims.sample.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SampleService implements ISampleService{
    private HashMap<Long, Sample> sampleMap;
    private SampleRepository repository;
    @Override
    public Iterable<Sample> allSamples() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }
}

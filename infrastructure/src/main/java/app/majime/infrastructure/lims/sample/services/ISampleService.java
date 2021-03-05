package app.majime.infrastructure.lims.sample.services;

import app.majime.infrastructure.lims.sample.DTOs.SampleDTO;

public interface ISampleService {

    Iterable<SampleDTO> allSamples();
}

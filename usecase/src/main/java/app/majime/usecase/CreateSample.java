package app.majime.usecase;

import app.majime.domain.entity.Sample;
import app.majime.usecase.port.SampleRepository;
import app.majime.usecase.validator.SampleValidator;

public final class CreateSample {

    private final SampleRepository repository;


    public CreateSample(SampleRepository repository) {
        this.repository = repository;
    }

    public Sample create(final Sample sample){
        SampleValidator.validateCreateSample(sample);
        if (repository.findById(sample.getId()).isPresent()) {
            throw new NullPointerException(sample.getId()+"");
        }
        var userToSave = Sample.builder()
                .id(sample.getId())
                .sample_no(sample.getSample_no())
                .quantity(sample.getQuantity())
                .status(sample.getStatus())
                .batch_id(sample.getBatch_id())
                .user_id(sample.getUser_id())
                .specification_id(sample.getSpecification_id())
                .build();
        return repository.create(userToSave);
    }

}

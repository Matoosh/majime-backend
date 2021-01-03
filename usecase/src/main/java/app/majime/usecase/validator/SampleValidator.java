package app.majime.usecase.validator;

import app.majime.domain.entity.Sample;

public class SampleValidator {

    public static void validateCreateSample(final Sample sample) {
        if (sample == null) throw new NullPointerException("Sample should not be null");
    }

    private SampleValidator() {

    }
}

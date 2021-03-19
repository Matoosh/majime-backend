package app.majime.infrastructure.lims.sample;

import java.util.Arrays;

enum SampleStatus {

    //fixme Proponowałbym status jako String do bazy, tj.: NEW, APPROVED, DELETED....
    //wtedy możemy usunąć konstruktor, i całe bebechy

    NEW(1L);

    private final Long status;

    SampleStatus(Long status) {
        this.status = status;
    }

    static SampleStatus fromValue(Long status) {
        return Arrays.stream(values())
                .filter(sampleStatus -> sampleStatus.status.equals(status))
                .findFirst()
                .orElse(null);
    }
}

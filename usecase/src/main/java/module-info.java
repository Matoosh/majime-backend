module majime.backend.gradle.usecase {
    exports app.majime.usecase;
    exports app.majime.usecase.port;
    requires majime.backend.gradle.domain;
}
package app.majime.core.manufacturer.usecase;

public interface GetManufacturer {

    Long getId();

    String getName();
    char getDeleted();

    Long getAddress_id();

}

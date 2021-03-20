package app.majime.infrastructure.lims.manufacturer.usecase;

public interface SetManufacturer {

    void setId(Long id);

    void setName(String name);
    void setDeleted(char deleted);

    void address_id(Long address_id);

}

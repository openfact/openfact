package org.openfact.models;

public interface CompanyModel extends Model {

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    UserModel getOwner();
}

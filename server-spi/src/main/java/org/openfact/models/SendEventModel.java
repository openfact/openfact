package org.openfact.models;

public interface SendEventModel {

    String getId();

    boolean getResult();

    void setResult(boolean result);

    String getDescription();

    void setDescription(String description);

    OrganizationModel getOrganization();
}

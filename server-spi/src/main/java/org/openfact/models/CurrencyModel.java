package org.openfact.models;

public interface CurrencyModel {

    String getId();

    String getCode();

    void setCode(String code);

    int getPriority();

    void setPriority(int priority);

    OrganizationModel getOrganization();
}

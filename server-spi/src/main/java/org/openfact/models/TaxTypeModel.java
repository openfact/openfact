package org.openfact.models;

import java.math.BigDecimal;

public interface TaxTypeModel {

    String getId();

    String getName();

    void setName(String name);

    String getCode();

    void setCode(String code);

    BigDecimal getValue();

    void setValue(BigDecimal value);

    OrganizationModel getOrganization();

}

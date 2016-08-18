package org.openfact.models;

import java.math.BigDecimal;

import org.openfact.models.enums.DocumentType;

public interface DocumentModel {

    String getId();

    DocumentType getType();

    void setType(DocumentType type);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getCode();

    void setCode(String code);

    BigDecimal getValue();

    void setValue(BigDecimal value);

    OrganizationModel getOrganization();

}

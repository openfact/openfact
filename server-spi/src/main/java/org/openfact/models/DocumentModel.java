package org.openfact.models;

import org.openfact.models.enums.DocumentType;

public interface DocumentModel {

    String getId();

    String getName();

    void setName(String name);

    String getDocumentId();

    void setDocumentId(String documentId);

    String getDescription();

    void setDescription(String description);

    DocumentType getType();

    void setType(DocumentType type);

    String getCode();

    void setCode(String code);   

    OrganizationModel getOrganization();

}

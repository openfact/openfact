package org.openfact.models.ubl.common;

public interface LineReferenceModel {

    LineIDModel getLineID();

    void setLineID(LineIDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    String getLineStatusCode();

    void setLineStatusCode(String value);

    DocumentReferenceModel getDocumentReference();

    void setDocumentReference(DocumentReferenceModel value);

    String getId();

    void setId(String value);

}

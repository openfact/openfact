package org.openfact.models.ubl.common;

public interface LineReferenceType {

    LineIDType getLineID();

    void setLineID(LineIDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    LineStatusCodeTypeCommBas getLineStatusCode();

    void setLineStatusCode(LineStatusCodeTypeCommBas value);

    DocumentReferenceType getDocumentReference();

    void setDocumentReference(DocumentReferenceType value);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

public interface LineReferenceModel {

    LineIDModel getLineID();

    void setLineID(LineIDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    LineStatusCodeModelCommBas getLineStatusCode();

    void setLineStatusCode(LineStatusCodeModelCommBas value);

    DocumentReferenceModel getDocumentReference();

    void setDocumentReference(DocumentReferenceModel value);

    String getId();

    void setId(String value);

}

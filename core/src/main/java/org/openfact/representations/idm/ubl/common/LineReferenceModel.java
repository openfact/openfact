package org.openfact.representations.idm.ubl.common;

public interface LineReferenceModel {

    String getLineID();

    void setLineID(String value);

    String getUUID();

    void setUUID(String value);

    String getLineStatusCode();

    void setLineStatusCode(String value);

    DocumentReferenceModel getDocumentReference();

    void setDocumentReference(DocumentReferenceModel value);

    String getId();

    void setId(String value);

}

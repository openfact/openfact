package org.openfact.models.ubl.common;

public interface AttachmentType {

    EmbeddedDocumentBinaryObjectType getEmbeddedDocumentBinaryObject();

    void setEmbeddedDocumentBinaryObject(EmbeddedDocumentBinaryObjectType value);

    ExternalReferenceType getExternalReference();

    void setExternalReference(ExternalReferenceType value);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

public interface AttachmentModel {

    EmbeddedDocumentBinaryObjectModel getEmbeddedDocumentBinaryObject();

    void setEmbeddedDocumentBinaryObject(EmbeddedDocumentBinaryObjectModel value);

    ExternalReferenceModel getExternalReference();

    void setExternalReference(ExternalReferenceModel value);

    String getId();

    void setId(String value);

}

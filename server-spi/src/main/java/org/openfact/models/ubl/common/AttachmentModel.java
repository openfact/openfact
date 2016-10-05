package org.openfact.models.ubl.common;

public interface AttachmentModel {

    BinaryObjectModel getEmbeddedDocumentBinaryObject();

    void setEmbeddedDocumentBinaryObject(BinaryObjectModel value);

    ExternalReferenceModel getExternalReference();

    void setExternalReference(ExternalReferenceModel value);

    String getId();

    

}

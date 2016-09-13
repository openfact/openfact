package org.openfact.models.ubl;

import org.openfact.models.ubl.type.BinaryObjectModel;

public interface AttachmentModel {

    BinaryObjectModel getEmbeddedDocumentBinaryObject();

    void setEmbeddedDocumentBinaryObject(BinaryObjectModel embeddedDocumentBinaryObject);

    ExternalReferenceModel getExternalReference();

    void setExternalReference(ExternalReferenceModel externalReference);
}

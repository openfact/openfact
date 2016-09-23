package org.openfact.representations.idm.ubl.common;

public class AttachmentRepresentation {
    private BinaryObjectRepresentation embeddedDocumentBinaryObject;
    private ExternalReferenceRepresentation externalReference;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExternalReferenceRepresentation getExternalReference() {
        return this.externalReference;
    }

    public void setExternalReference(ExternalReferenceRepresentation externalReference) {
        this.externalReference = externalReference;
    }

    public BinaryObjectRepresentation getEmbeddedDocumentBinaryObject() {
        return this.embeddedDocumentBinaryObject;
    }

    public void setEmbeddedDocumentBinaryObject(BinaryObjectRepresentation embeddedDocumentBinaryObject) {
        this.embeddedDocumentBinaryObject = embeddedDocumentBinaryObject;
    }
}
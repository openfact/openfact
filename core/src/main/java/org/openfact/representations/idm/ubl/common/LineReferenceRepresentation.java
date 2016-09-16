package org.openfact.representations.idm.ubl.common;

public class LineReferenceRepresentation {
    private String lineID;
    private String UUID;
    private String lineStatusCode;
    private DocumentReferenceRepresentation documentReference;
    private String id;

    public String getLineStatusCode() {
        return this.lineStatusCode;
    }

    public void setLineStatusCode(String lineStatusCode) {
        this.lineStatusCode = lineStatusCode;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocumentReferenceRepresentation getDocumentReference() {
        return this.documentReference;
    }

    public void setDocumentReference(DocumentReferenceRepresentation documentReference) {
        this.documentReference = documentReference;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getLineID() {
        return this.lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }
}
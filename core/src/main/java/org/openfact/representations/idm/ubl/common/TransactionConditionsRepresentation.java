package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class TransactionConditionsRepresentation {
    private String idUbl;
    private String actionCode;
    private List<String> description;
    private List<DocumentReferenceRepresentation> documentReference;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getActionCode() {
        return this.actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DocumentReferenceRepresentation> getDocumentReference() {
        return this.documentReference;
    }

    public void setDocumentReference(List<DocumentReferenceRepresentation> documentReference) {
        this.documentReference = documentReference;
    }

    public List<String> getDescription() {
        return this.description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class ResponseRepresentation {
    private String referenceID;
    private String responseCode;
    private List<String> description;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDescription() {
        return this.description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getReferenceID() {
        return this.referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }
}
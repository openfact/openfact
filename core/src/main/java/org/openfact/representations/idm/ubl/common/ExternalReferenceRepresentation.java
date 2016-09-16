package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExternalReferenceRepresentation {
    private String URI;
    private String documentHash;
    private LocalDate expiryDate;
    private LocalTime expiryTime;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentHash() {
        return this.documentHash;
    }

    public void setDocumentHash(String documentHash) {
        this.documentHash = documentHash;
    }

    public String getURI() {
        return this.URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalTime getExpiryTime() {
        return this.expiryTime;
    }

    public void setExpiryTime(LocalTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
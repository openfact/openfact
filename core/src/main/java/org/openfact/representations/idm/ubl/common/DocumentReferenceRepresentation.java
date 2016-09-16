package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class DocumentReferenceRepresentation {
    private String ID;
    private Boolean copyIndicator;
    private String UUID;
    private LocalDate issueDate;
    private String documentCodeRepresentation;
    private String documentRepresentation;
    private List<String> XPath;
    private AttachmentRepresentation attachment;
    private String id;

    public String getDocumentCodeRepresentation() {
        return this.documentCodeRepresentation;
    }

    public void setDocumentCodeRepresentation(String documentCodeRepresentation) {
        this.documentCodeRepresentation = documentCodeRepresentation;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<String> getXPath() {
        return this.XPath;
    }

    public void setXPath(List<String> XPath) {
        this.XPath = XPath;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getDocumentRepresentation() {
        return this.documentRepresentation;
    }

    public void setDocumentRepresentation(String documentRepresentation) {
        this.documentRepresentation = documentRepresentation;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public AttachmentRepresentation getAttachment() {
        return this.attachment;
    }

    public void setAttachment(AttachmentRepresentation attachment) {
        this.attachment = attachment;
    }

    public Boolean getCopyIndicator() {
        return this.copyIndicator;
    }

    public void setCopyIndicator(Boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }
}
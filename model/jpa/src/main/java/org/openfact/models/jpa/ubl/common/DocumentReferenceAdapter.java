package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class DocumentReferenceAdapter implements DocumentReferenceModel, JpaModel<DocumentReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(DocumentReferenceAdapter.class);
    protected DocumentReferenceEntity documentReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public DocumentReferenceAdapter(OpenfactSession session, EntityManager em,
            DocumentReferenceEntity documentReference) {
        this.session = session;
        this.em = em;
        this.documentReference = documentReference;
    }

    String getID() {
        return this.documentReference.getID();
    }

    void setID(String value) {
        this.documentReference.setID(value);
    }

    boolean getCopyIndicator() {
        return this.documentReference.getCopyIndicator();
    }

    void setCopyIndicator(boolean value) {
        this.documentReference.setCopyIndicator(value);
    }

    String getUUID() {
        return this.documentReference.getUUID();
    }

    void setUUID(String value) {
        this.documentReference.setUUID(value);
    }

    LocalDate getIssueDate() {
        return this.documentReference.getIssueDate();
    }

    void setIssueDate(LocalDate value) {
        this.documentReference.setIssueDate(value);
    }

    String getDocumentCodeAdapter() {
        return this.documentReference.getDocumentCodeAdapter();
    }

    void setDocumentCodeAdapter(String value) {
        this.documentReference.setDocumentCodeAdapter(value);
    }

    String getDocumentAdapter() {
        return this.documentReference.getDocumentAdapter();
    }

    void setDocumentAdapter(String value) {
        this.documentReference.setDocumentAdapter(value);
    }

    List<String> getXPath() {
        return this.documentReference.getXPath();
    }

    void setXPath(List<String> xPath) {
        this.documentReference.setXPath(xPath);
    }

    AttachmentAdapter getAttachment() {
        return this.documentReference.getAttachment();
    }

    void setAttachment(AttachmentAdapter value) {
        this.documentReference.setAttachment(value);
    }

    String getId() {
        return this.documentReference.getId();
    }

    void setId(String value) {
        this.documentReference.setId(value);
    }

}

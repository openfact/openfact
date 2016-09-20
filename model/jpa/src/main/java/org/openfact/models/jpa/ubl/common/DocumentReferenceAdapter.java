package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;

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

    @Override
    public String getID() {
        return this.documentReference.getID();
    }

    @Override
    public void setID(String value) {
        this.documentReference.setID(value);
    }

    @Override
    public boolean getCopyIndicator() {
        return this.documentReference.isCopyIndicator();
    }

    @Override
    public void setCopyIndicator(boolean value) {
        this.documentReference.setCopyIndicator(value);
    }

    @Override
    public String getUUID() {
        return this.documentReference.getUuid();
    }

    @Override
    public void setUUID(String value) {
        this.documentReference.setUuid(value);
        ;
    }

    @Override
    public LocalDate getIssueDate() {
        return this.documentReference.getIssueDate();
    }

    @Override
    public void setIssueDate(LocalDate value) {
        this.documentReference.setIssueDate(value);
    }

    @Override
    public String getDocumentCode() {
        return this.documentReference.getDocumentCode();
    }

    @Override
    public void setDocumentCode(String value) {
        this.documentReference.setDocumentCode(value);
    }

    @Override
    public String getDocument() {
        return this.documentReference.getDocument();
    }

    @Override
    public void setDocument(String value) {
        this.documentReference.setDocument(value);
    }

    @Override
    public List<String> getXPath() {
        return this.documentReference.getxPath();
    }

    @Override
    public void setXPath(List<String> xPath) {
        this.documentReference.setxPath(xPath);
    }

    @Override
    public AttachmentModel getAttachment() {
        return new AttachmentAdapter(session, em, this.documentReference.getAttachment());
    }

    @Override
    public void setAttachment(AttachmentModel value) {
        this.documentReference.setAttachment(AttachmentAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.documentReference.getId();
    }

    @Override
    public void setId(String value) {
        this.documentReference.setId(value);
    }

    @Override
    public DocumentReferenceEntity getEntity() {
        return this.documentReference;
    }

    public static DocumentReferenceEntity toEntity(DocumentReferenceModel model, EntityManager em) {
        if (model instanceof DocumentReferenceAdapter) {
            return ((DocumentReferenceAdapter) model).getEntity();
        }
        return em.getReference(DocumentReferenceEntity.class, model.getId());
    }

}

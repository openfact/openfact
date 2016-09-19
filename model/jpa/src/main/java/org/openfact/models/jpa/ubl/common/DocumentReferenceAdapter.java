package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
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
        return this.documentReference.getCopyIndicator();
    }

    @Override
    public void setCopyIndicator(boolean value) {
        this.documentReference.setCopyIndicator(value);
    }

    @Override
    public String getUUID() {
        return this.documentReference.getUUID();
    }

    @Override
    public void setUUID(String value) {
        this.documentReference.setUUID(value);
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
    public String getDocumentCodeModel() {
        return this.documentReference.getDocumentCodeModel();
    }

    @Override
    public void setDocumentCodeAdapter(String value) {
        this.documentReference.setDocumentCodeAdapter(value);
    }

    @Override
    public String getDocumentModel() {
        return this.documentReference.getDocumentModel();
    }

    @Override
    public void setDocumentAdapter(String value) {
        this.documentReference.setDocumentAdapter(value);
    }

    @Override
    public List<String> getXPath() {
        return this.documentReference.getXPath();
    }

    @Override
    public void setXPath(List<String> xPath) {
        this.documentReference.setXPath(xPath);
    }

    @Override
    public AttachmentModel getAttachment() {
        return this.documentReference.getAttachment();
    }

    @Override
    public void setAttachment(AttachmentAdapter value) {
        this.documentReference.setAttachment(value);
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDocumentCodeModel(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDocumentModel(String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setAttachment(AttachmentModel value) {
        // TODO Auto-generated method stub
        
    }

    public static DocumentReferenceEntity toEntity(DocumentReferenceModel value) {
        // TODO Auto-generated method stub
        return null;
    }

}

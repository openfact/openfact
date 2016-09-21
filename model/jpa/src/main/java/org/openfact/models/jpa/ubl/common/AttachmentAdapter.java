package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AttachmentEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.BinaryObjectModel;
import org.openfact.models.ubl.common.ExternalReferenceModel;

public class AttachmentAdapter implements AttachmentModel, JpaModel<AttachmentEntity> {

    protected static final Logger logger = Logger.getLogger(AttachmentAdapter.class);
    protected AttachmentEntity attachment;
    protected EntityManager em;
    protected OpenfactSession session;

    public AttachmentAdapter(OpenfactSession session, EntityManager em, AttachmentEntity attachment) {
        this.session = session;
        this.em = em;
        this.attachment = attachment;
    }

    @Override
    public BinaryObjectModel getEmbeddedDocumentBinaryObject() {
        return new BinaryObjectAdapter(session, em, attachment.getEmbeddedDocumentBinaryObject());
    }

    @Override
    public void setEmbeddedDocumentBinaryObject(BinaryObjectModel value) {
        attachment.setEmbeddedDocumentBinaryObject(BinaryObjectAdapter.toEntity(value, em));
    }

    @Override
    public ExternalReferenceModel getExternalReference() {
        return new ExternalReferenceAdapter(session, em, attachment.getExternalReference());
    }

    @Override
    public void setExternalReference(ExternalReferenceModel value) {
        attachment.setExternalReference(ExternalReferenceAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return attachment.getId();
    }

    @Override
    public void setId(String value) {
        attachment.setId(value);
    }

    @Override
    public AttachmentEntity getEntity() {
        return attachment;
    }

    public static AttachmentEntity toEntity(AttachmentModel model, EntityManager em) {
        if (model instanceof AllowanceChargeModel) {
            return ((AttachmentAdapter) model).getEntity();
        }
        return em.getReference(AttachmentEntity.class, model.getId());
    }

}

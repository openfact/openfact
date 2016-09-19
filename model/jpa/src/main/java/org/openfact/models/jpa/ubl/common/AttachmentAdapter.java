package org.openfact.models.jpa.ubl.common;

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

    BinaryObjectAdapter getEmbeddedDocumentBinaryObject() {
        return this.attachment.getEmbeddedDocumentBinaryObject();
    }

    void setEmbeddedDocumentBinaryObject(BinaryObjectAdapter value) {
        this.attachment.setEmbeddedDocumentBinaryObject(value);
    }

    ExternalReferenceAdapter getExternalReference() {
        return this.attachment.getExternalReference();
    }

    void setExternalReference(ExternalReferenceAdapter value) {
        this.attachment.setExternalReference(value);
    }

    String getId() {
        return this.attachment.getId();
    }

    void setId(String value) {
        this.attachment.setId(value);
    }

}

package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AttachmentEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceLineEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.BillingReferenceLineModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;

public class BillingReferenceAdapter implements BillingReferenceModel, JpaModel<BillingReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(BillingReferenceAdapter.class);

    protected BillingReferenceEntity billingReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public BillingReferenceAdapter(OpenfactSession session, EntityManager em,
            BillingReferenceEntity billingReference) {
        this.session = session;
        this.em = em;
        this.billingReference = billingReference;
    }

    @Override
    public DocumentReferenceModel getInvoiceDocumentReference() {
        return new DocumentReferenceAdapter(session, em, billingReference.getInvoiceDocumentReference());
    }

    @Override
    public void setInvoiceDocumentReference(DocumentReferenceModel value) {
        billingReference.setInvoiceDocumentReference(DocumentReferenceAdapter.toEntity(value));
    }

    @Override
    public DocumentReferenceModel getSelfBilledInvoiceDocumentReference() {
        return new DocumentReferenceAdapter(session, em,
                billingReference.getSelfBilledInvoiceDocumentReference());
    }

    @Override
    public void setSelfBilledInvoiceDocumentReference(DocumentReferenceModel value) {
        billingReference.setSelfBilledInvoiceDocumentReference(DocumentReferenceAdapter.toEntity(value));
    }

    @Override
    public DocumentReferenceModel getCreditNoteDocumentReference() {
        return new DocumentReferenceAdapter(session, em, billingReference.getCreditNoteDocumentReference());
    }

    @Override
    public void setCreditNoteDocumentReference(DocumentReferenceModel value) {
        billingReference.setCreditNoteDocumentReference(DocumentReferenceAdapter.toEntity(value));
    }

    @Override
    public DocumentReferenceModel getSelfBilledCreditNoteDocumentReference() {
        return new DocumentReferenceAdapter(session, em,
                billingReference.getSelfBilledCreditNoteDocumentReference());
    }

    @Override
    public void setSelfBilledCreditNoteDocumentReference(DocumentReferenceModel value) {
        billingReference.setSelfBilledCreditNoteDocumentReference(DocumentReferenceAdapter.toEntity(value));
    }

    @Override
    public DocumentReferenceModel getDebitNoteDocumentReference() {
        return new DocumentReferenceAdapter(session, em, billingReference.getDebitNoteDocumentReference());
    }

    @Override
    public void setDebitNoteDocumentReference(DocumentReferenceModel value) {
        billingReference.setDebitNoteDocumentReference(DocumentReferenceAdapter.toEntity(value));
    }

    @Override
    public DocumentReferenceModel getReminderDocumentReference() {
        return new DocumentReferenceAdapter(session, em, billingReference.getReminderDocumentReference());
    }

    @Override
    public void setReminderDocumentReference(DocumentReferenceModel value) {
        billingReference.setReminderDocumentReference(DocumentReferenceAdapter.toEntity(value));
    }

    @Override
    public DocumentReferenceModel getAdditionalDocumentReference() {
        return new DocumentReferenceAdapter(session, em, billingReference.getAdditionalDocumentReference());
    }

    @Override
    public void setAdditionalDocumentReference(DocumentReferenceModel value) {
        billingReference.setAdditionalDocumentReference(DocumentReferenceAdapter.toEntity(value));
    }

    @Override
    public List<BillingReferenceLineModel> getBillingReferenceLine() {
        return billingReference.getBillingReferenceLine().stream()
                .map(f -> new BillingReferenceLineAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setBillingReferenceLine(List<BillingReferenceLineModel> billingReferenceLine) {
        List<BillingReferenceLineEntity> entities = billingReferenceLine.stream()
                .map(f -> BillingReferenceLineAdapter.toEntity(f, em)).collect(Collectors.toList());
        billingReference.setBillingReferenceLine(entities);
    }

    @Override
    public String getId() {
        return billingReference.getId();
    }

    @Override
    public void setId(String value) {
        billingReference.setId(value);
    }

    @Override
    public BillingReferenceEntity getEntity() {
        return billingReference;
    }

    public static BillingReferenceEntity toEntity(BillingReferenceModel model, EntityManager em) {
        if (model instanceof AllowanceChargeModel) {
            return ((BillingReferenceAdapter) model).getEntity();
        }
        return em.getReference(BillingReferenceEntity.class, model.getId());
    }
}

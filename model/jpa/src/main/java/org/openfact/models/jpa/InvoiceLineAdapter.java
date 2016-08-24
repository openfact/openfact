package org.openfact.models.jpa;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceLineTaxTotalModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.DocumentSnapshotEntity;
import org.openfact.models.jpa.entities.InvoiceLineEntity;
import org.openfact.models.jpa.entities.InvoiceLineTaxTotalEntity;

public class InvoiceLineAdapter implements InvoiceLineModel, JpaModel<InvoiceLineEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceLineAdapter.class);

    protected InvoiceModel invoice;
    protected InvoiceLineEntity invoiceLine;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceLineAdapter(OpenfactSession session, InvoiceModel invoice, EntityManager em,
            InvoiceLineEntity invoiceLine) {
        this.session = session;
        this.em = em;
        this.invoiceLine = invoiceLine;
        this.invoice = invoice;
    }

    @Override
    public InvoiceLineEntity getEntity() {
        return invoiceLine;
    }

    public static InvoiceLineEntity toEntity(InvoiceLineModel model, EntityManager em) {
        if (model instanceof InvoiceLineAdapter) {
            return ((InvoiceLineAdapter) model).getEntity();
        }
        return em.getReference(InvoiceLineEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return invoiceLine.getId();
    }

    @Override
    public int getOrderNumber() {
        return invoiceLine.getOrderNumber();
    }

    @Override
    public void setOrderNumber(int orderNumber) {
        invoiceLine.setOrderNumber(orderNumber);
    }

    @Override
    public BigDecimal getQuantity() {
        return invoiceLine.getQuantity();
    }

    @Override
    public void setQuantity(BigDecimal quantity) {
        invoiceLine.setQuantity(quantity);
    }

    @Override
    public String getUnitCode() {
        return invoiceLine.getUnitCode();
    }

    @Override
    public void setUnitCode(String uniCode) {
        invoiceLine.setUnitCode(uniCode);
    }

    @Override
    public BigDecimal getPrice() {
        return invoiceLine.getPrice();
    }

    @Override
    public void setPrice(BigDecimal price) {
        invoiceLine.setPrice(price);
    }

    @Override
    public BigDecimal getExtensionAmount() {
        return invoiceLine.getExtensionAmount();
    }

    @Override
    public BigDecimal getAmount() {
        return invoiceLine.getAmount();
    }

    @Override
    public void setAmount(BigDecimal amount) {
        invoiceLine.setAmount(amount);
    }

    @Override
    public BigDecimal getAllowanceCharge() {
        return invoiceLine.getAllowanceCharge();
    }

    @Override
    public void setAllowanceCharge(BigDecimal allowanceCharge) {
        invoiceLine.setAllowanceCharge(allowanceCharge);
    }

    @Override
    public String getItemDescription() {
        return invoiceLine.getItemDescription();
    }

    @Override
    public void setItemDescription(String itemDescription) {
        invoiceLine.setItemDescription(itemDescription);
    }

    @Override
    public String getItemIdentification() {
        return invoiceLine.getItemIdentification();
    }

    @Override
    public void setItemIdentification(String itemIdentification) {
        invoiceLine.setItemIdentification(itemIdentification);
    }

    @Override
    public Set<InvoiceLineTaxTotalModel> getTotalTaxs() {
        return invoiceLine.getTaxTotals().stream()
                .map(f -> new InvoiceLineTaxTotalAdapter(session, this, em, f)).collect(Collectors.toSet());
    }

    @Override
    public InvoiceLineTaxTotalModel addTotalTax(String documentName, String documentId, String reasonName,
            String reasonId, BigDecimal ammount) {
        DocumentSnapshotEntity document = new DocumentSnapshotEntity();
        document.setName(documentName);
        document.setDocumentId(documentId);

        DocumentSnapshotEntity reason = new DocumentSnapshotEntity();
        reason.setName(reasonName);
        reason.setDocumentId(documentId);

        InvoiceLineTaxTotalEntity taxTotalEntity = new InvoiceLineTaxTotalEntity();
        taxTotalEntity.setAmount(ammount);
        taxTotalEntity.setDocument(document);
        taxTotalEntity.setReason(reason);
        taxTotalEntity.setInvoiceLine(invoiceLine);

        em.persist(taxTotalEntity);
        em.flush();

        return new InvoiceLineTaxTotalAdapter(session, this, em, taxTotalEntity);
    }

    @Override
    public InvoiceModel getInvoice() {
        return invoice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((invoiceLine == null) ? 0 : invoiceLine.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceLineAdapter other = (InvoiceLineAdapter) obj;
        if (invoiceLine == null) {
            if (other.invoiceLine != null)
                return false;
        } else if (!invoiceLine.equals(other.invoiceLine))
            return false;
        return true;
    }

}

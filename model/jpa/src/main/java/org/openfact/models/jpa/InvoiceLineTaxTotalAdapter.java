package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentSnapshotModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceLineTaxTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.DocumentSnapshotEntity;
import org.openfact.models.jpa.entities.InvoiceLineTaxTotalEntity;

/**
 * @author carlosthe19916@sistcoop.com
 */

public class InvoiceLineTaxTotalAdapter
        implements InvoiceLineTaxTotalModel, JpaModel<InvoiceLineTaxTotalEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceLineTaxTotalAdapter.class);

    protected InvoiceLineModel invoiceLine;
    protected InvoiceLineTaxTotalEntity taxTotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceLineTaxTotalAdapter(OpenfactSession session, InvoiceLineModel invoiceLine, EntityManager em,
            InvoiceLineTaxTotalEntity taxTotal) {
        this.session = session;
        this.em = em;
        this.invoiceLine = invoiceLine;
        this.taxTotal = taxTotal;
    }

    @Override
    public InvoiceLineTaxTotalEntity getEntity() {
        return taxTotal;
    }

    @Override
    public String getId() {
        return taxTotal.getId();
    }

    @Override
    public BigDecimal getAmmount() {
        return taxTotal.getAmount();
    }

    @Override
    public void setAmmount(BigDecimal ammount) {
        taxTotal.setAmount(ammount);
    }

    @Override
    public DocumentSnapshotModel getDocument() {
        return new DocumentSnapshotAdapter(session, em, taxTotal.getDocument());
    }

    @Override
    public void setDocument(String documentName, String documentId) {
        DocumentSnapshotEntity document = new DocumentSnapshotEntity();
        document.setName(documentName);
        document.setDocumentId(documentId);

        taxTotal.setDocument(document);
    }

    @Override
    public DocumentSnapshotModel getReason() {
        return new DocumentSnapshotAdapter(session, em, taxTotal.getReason());
    }

    @Override
    public void setReason(String documentName, String documentId) {
        DocumentSnapshotEntity document = new DocumentSnapshotEntity();
        document.setName(documentName);
        document.setDocumentId(documentId);

        taxTotal.setDocument(document);
    }

    @Override
    public InvoiceLineModel getInvoiceLine() {
        return invoiceLine;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taxTotal == null) ? 0 : taxTotal.hashCode());
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
        InvoiceLineTaxTotalAdapter other = (InvoiceLineTaxTotalAdapter) obj;
        if (taxTotal == null) {
            if (other.taxTotal != null)
                return false;
        } else if (!taxTotal.equals(other.taxTotal))
            return false;
        return true;
    }

}

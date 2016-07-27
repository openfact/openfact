package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.InvoiceIdModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.InvoiceIdEntity;

public class InvoiceIdAdapter implements InvoiceIdModel, JpaModel<InvoiceIdEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceIdAdapter.class);

    protected InvoiceModel invoice;
    protected InvoiceIdEntity invoiceId;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceIdAdapter(OpenfactSession session, InvoiceModel invoice, EntityManager em,
            InvoiceIdEntity invoiceId) {
        this.session = session;
        this.em = em;
        this.invoiceId = invoiceId;
        this.invoice = invoice;
    }

    @Override
    public InvoiceIdEntity getEntity() {
        return invoiceId;
    }

    public static InvoiceIdEntity toEntity(InvoiceIdModel model, EntityManager em) {
        if (model instanceof InvoiceIdAdapter) {
            return ((InvoiceIdAdapter) model).getEntity();
        }
        return em.getReference(InvoiceIdEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return invoiceId.getId();
    }

    @Override
    public int getSeries() {
        return invoiceId.getSeries();
    }

    @Override
    public int getNumber() {
        return invoiceId.getNumber();
    }

    @Override
    public InvoiceModel getInvoice() {
        return invoice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
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
        InvoiceIdAdapter other = (InvoiceIdAdapter) obj;
        if (invoiceId == null) {
            if (other.invoiceId != null)
                return false;
        } else if (!invoiceId.equals(other.invoiceId))
            return false;
        return true;
    }

}

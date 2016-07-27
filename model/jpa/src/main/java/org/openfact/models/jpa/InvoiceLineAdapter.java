package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.InvoiceLineEntity;

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
    public BigDecimal getQuantity() {
        return invoiceLine.getQuantity();
    }

    @Override
    public void setQuantity(BigDecimal quantity) {
        invoiceLine.setQuantity(quantity);
    }

    @Override
    public BigDecimal getAmmount() {
        return invoiceLine.getAmmount();
    }

    @Override
    public void setAmmount(BigDecimal ammount) {
        invoiceLine.setAmmount(ammount);
    }

    @Override
    public String getDescription() {
        return invoiceLine.getDescription();
    }

    @Override
    public void setDescription(String description) {
        invoiceLine.setDescription(description);
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

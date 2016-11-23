package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.TaxTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.TaxTotalEntity;

public class TaxTotalAdapter implements TaxTotalModel, JpaModel<TaxTotalEntity> {

    protected static final Logger logger = Logger.getLogger(TaxTotalAdapter.class);
    protected TaxTotalEntity taxTotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxTotalAdapter(OpenfactSession session, EntityManager em, TaxTotalEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.taxTotal = supplierParty;
    }

    @Override
    public TaxTotalEntity getEntity() {
        return taxTotal;
    }

    @Override
    public String getId() {
        return taxTotal.getId();
    }

    @Override
    public BigDecimal getTaxAmount() {
        return taxTotal.getTaxAmount();
    }

    @Override
    public void setTaxAmount(BigDecimal value) {
        taxTotal.setTaxAmount(value);
    }

}

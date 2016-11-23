package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.AllowanceChargeModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.AllowanceChargeEntity;

public class AllowanceChargeAdapter implements AllowanceChargeModel, JpaModel<AllowanceChargeEntity> {

    protected static final Logger logger = Logger.getLogger(AllowanceChargeAdapter.class);
    protected AllowanceChargeEntity allowanceCharge;
    protected EntityManager em;
    protected OpenfactSession session;

    public AllowanceChargeAdapter(OpenfactSession session, EntityManager em,
            AllowanceChargeEntity allowanceCharge) {
        this.session = session;
        this.em = em;
        this.allowanceCharge = allowanceCharge;
    }

    @Override
    public AllowanceChargeEntity getEntity() {
        return allowanceCharge;
    }

    @Override
    public String getId() {
        return allowanceCharge.getId();
    }

    @Override
    public BigDecimal getAmount() {
        return allowanceCharge.getAmount();
    }

    @Override
    public void setAmount(BigDecimal value) {
        allowanceCharge.setAmount(value);
    }

}

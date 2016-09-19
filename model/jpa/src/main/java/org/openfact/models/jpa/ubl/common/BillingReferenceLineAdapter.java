package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class BillingReferenceLineAdapter
        implements BillingReferenceLineModel, JpaModel<BillingReferenceLineEntity> {

    protected static final Logger logger = Logger.getLogger(BillingReferenceLineAdapter.class);
    protected BillingReferenceLineEntity billingReferenceLine;
    protected EntityManager em;
    protected OpenfactSession session;

    public BillingReferenceLineAdapter(OpenfactSession session, EntityManager em,
            BillingReferenceLineEntity billingReferenceLine) {
        this.session = session;
        this.em = em;
        this.billingReferenceLine = billingReferenceLine;
    }

    String getID() {
        return this.billingReferenceLine.getID();
    }

    void setID(String value) {
        this.billingReferenceLine.setID(value);
    }

    BigDecimal getAmount() {
        return this.billingReferenceLine.getAmount();
    }

    void setAmount(BigDecimal value) {
        this.billingReferenceLine.setAmount(value);
    }

    List<AllowanceChargeAdapter> getAllowanceCharge() {
        return this.billingReferenceLine.getAllowanceCharge();
    }

    void setAllowanceCharge(List<AllowanceChargeAdapter> allowanceCharge) {
        this.billingReferenceLine.setAllowanceCharge(allowanceCharge);
    }

    String getId() {
        return this.billingReferenceLine.getId();
    }

    void setId(String value) {
        this.billingReferenceLine.setId(value);
    }

}

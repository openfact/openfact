package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceLineEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceLineModel;

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

    @Override
    public String getID() {
        return billingReferenceLine.getID();
    }

    @Override
    public void setID(String value) {
        billingReferenceLine.setID(value);
    }

    @Override
    public BigDecimal getAmount() {
        return billingReferenceLine.getAmount();
    }

    @Override
    public void setAmount(BigDecimal value) {
        billingReferenceLine.setAmount(value);
    }

    @Override
    public List<AllowanceChargeModel> getAllowanceCharge() {
        return billingReferenceLine.getAllowanceCharge().stream()
                .map(f -> new AllowanceChargeAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge) {
        List<AllowanceChargeEntity> entities = allowanceCharge.stream()
                .map(f -> AllowanceChargeAdapter.toEntity(f, em)).collect(Collectors.toList());
        billingReferenceLine.setAllowanceCharge(entities);
    }

    @Override
    public String getId() {
        return billingReferenceLine.getId();
    }

    @Override
    public void setId(String value) {
        billingReferenceLine.setId(value);
    }

    @Override
    public BillingReferenceLineEntity getEntity() {
        return billingReferenceLine;
    }

    public static BillingReferenceLineEntity toEntity(BillingReferenceLineModel model, EntityManager em) {
        if (model instanceof BillingReferenceLineAdapter) {
            return ((BillingReferenceLineAdapter) model).getEntity();
        }
        return em.getReference(BillingReferenceLineEntity.class, model.getId());
    }

}

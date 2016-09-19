package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.TaxSubtotalEntity;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;

public class TaxSubtotalAdapter implements TaxSubtotalModel, JpaModel<TaxSubtotalEntity> {

    protected static final Logger logger = Logger.getLogger(TaxSubtotalAdapter.class);
    
    protected TaxSubtotalEntity taxSubtotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxSubtotalAdapter(OpenfactSession session, EntityManager em, TaxSubtotalEntity taxSubtotal) {
        this.session = session;
        this.em = em;
        this.taxSubtotal = taxSubtotal;
    }

    @Override
    public BigDecimal getTaxableAmount() {
        return this.taxSubtotal.getTaxableAmount();
    }

    @Override
    public void setTaxableAmount(BigDecimal value) {
        this.taxSubtotal.setTaxableAmount(value);
    }

    @Override
    public BigDecimal getTaxAmount() {
        return this.taxSubtotal.getTaxAmount();
    }

    @Override
    public void setTaxAmount(BigDecimal value) {
        this.taxSubtotal.setTaxAmount(value);
    }

    @Override
    public BigDecimal getCalculationSequenceNumeric() {
        return this.taxSubtotal.getCalculationSequenceNumeric();
    }

    @Override
    public void setCalculationSequenceNumeric(BigDecimal value) {
        this.taxSubtotal.setCalculationSequenceNumeric(value);
    }

    @Override
    public BigDecimal getTransactionCurrencyTaxAmount() {
        return this.taxSubtotal.getTransactionCurrencyTaxAmount();
    }

    @Override
    public void setTransactionCurrencyTaxAmount(BigDecimal value) {
        this.taxSubtotal.setTransactionCurrencyTaxAmount(value);
    }

    @Override
    public BigDecimal getPercent() {
        return this.taxSubtotal.getPercent();
    }

    @Override
    public void setPercent(BigDecimal value) {
        this.taxSubtotal.setPercent(value);
    }

    @Override
    public MeasureModel getBaseUnitMeasure() {
        return new MeasureAdapter(session, em, taxSubtotal.getBaseUnitMeasure());
    }

    @Override
    public void setBaseUnitMeasure(MeasureModel value) {
        taxSubtotal.setBaseUnitMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public BigDecimal getPerUnitAmount() {
        return this.taxSubtotal.getPerUnitAmount();
    }

    @Override
    public void setPerUnitAmount(BigDecimal value) {
        this.taxSubtotal.setPerUnitAmount(value);
    }

    @Override
    public String getTierRange() {
        return this.taxSubtotal.getTierRange();
    }

    @Override
    public void setTierRange(String value) {
        this.taxSubtotal.setTierRange(value);
    }

    @Override
    public BigDecimal getTierRatePercent() {
        return this.taxSubtotal.getTierRatePercent();
    }

    @Override
    public void setTierRatePercent(BigDecimal value) {
        this.taxSubtotal.setTierRatePercent(value);
    }

    @Override
    public TaxCategoryModel getTaxCategory() {
        return new TaxCategoryAdapter(session, em, taxSubtotal.getTaxCategory());
    }

    @Override
    public void setTaxCategory(TaxCategoryModel value) {
        this.taxSubtotal.setTaxCategory(TaxCategoryAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.taxSubtotal.getId();
    }

    @Override
    public void setId(String value) {
        this.taxSubtotal.setId(value);
    }

    @Override
    public TaxSubtotalEntity getEntity() {
        // TODO Auto-generated method stub
        return taxSubtotal;
    }

    public static TaxSubtotalEntity toEntity(TaxSubtotalModel model, EntityManager em) {
        if (model instanceof TaxSubtotalModel) {
            return ((TaxSubtotalAdapter) model).getEntity();
        }
        return em.getReference(TaxSubtotalEntity.class, model.getId());
    }

}

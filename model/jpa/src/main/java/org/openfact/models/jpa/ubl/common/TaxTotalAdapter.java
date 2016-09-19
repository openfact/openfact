package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;

public class TaxTotalAdapter implements TaxTotalModel, JpaModel<TaxTotalEntity> {

    protected static final Logger logger = Logger.getLogger(TaxTotalAdapter.class);
    protected TaxTotalEntity taxTotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxTotalAdapter(OpenfactSession session, EntityManager em, TaxTotalEntity taxTotal) {
        this.session = session;
        this.em = em;
        this.taxTotal = taxTotal;
    }

    @Override
    public BigDecimal getTaxAmount() {
        return this.taxTotal.getTaxAmount();
    }

    @Override
    public void setTaxAmount(BigDecimal value) {
        this.taxTotal.setTaxAmount(value);
    }

    @Override
    public BigDecimal getRoundingAmount() {
        return this.taxTotal.getRoundingAmount();
    }

    @Override
    public void setRoundingAmount(BigDecimal value) {
        this.taxTotal.setRoundingAmount(value);
    }

    @Override
    public boolean getTaxEvidenceIndicator() {
        return this.taxTotal.getTaxEvidenceIndicator();
    }

    @Override
    public void setTaxEvidenceIndicator(boolean value) {
        this.taxTotal.setTaxEvidenceIndicator(value);
    }

    @Override
    public List<TaxSubtotalModel> getTaxSubtotal() {
        return this.taxTotal.getTaxSubtotal();
    }

    @Override
    public void setTaxSubtotal(List<TaxSubtotalAdapter> taxSubtotal) {
        this.taxTotal.setTaxSubtotal(taxSubtotal);
    }

    @Override
    public String getId() {
        return this.taxTotal.getId();
    }

    @Override
    public void setId(String value) {
        this.taxTotal.setId(value);
    }

    /**
     * */
    TaxSubtotalAdapter addTaxSubtotal();

    public static TaxTotalEntity toEntity(TaxTotalModel value) {
        // TODO Auto-generated method stub
        return null;
    }

}

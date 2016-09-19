package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

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

    BigDecimal getTaxAmount() {
        return this.taxTotal.getTaxAmount();
    }

    void setTaxAmount(BigDecimal value) {
        this.taxTotal.setTaxAmount(value);
    }

    BigDecimal getRoundingAmount() {
        return this.taxTotal.getRoundingAmount();
    }

    void setRoundingAmount(BigDecimal value) {
        this.taxTotal.setRoundingAmount(value);
    }

    boolean getTaxEvidenceIndicator() {
        return this.taxTotal.getTaxEvidenceIndicator();
    }

    void setTaxEvidenceIndicator(boolean value) {
        this.taxTotal.setTaxEvidenceIndicator(value);
    }

    List<TaxSubtotalAdapter> getTaxSubtotal() {
        return this.taxTotal.getTaxSubtotal();
    }

    void setTaxSubtotal(List<TaxSubtotalAdapter> taxSubtotal) {
        this.taxTotal.setTaxSubtotal(taxSubtotal);
    }

    String getId() {
        return this.taxTotal.getId();
    }

    void setId(String value) {
        this.taxTotal.setId(value);
    }

    /**
     * */
    TaxSubtotalAdapter addTaxSubtotal();

}

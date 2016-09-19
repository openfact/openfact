package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;

public class QuantityAdapter implements QuantityModel, JpaModel<QuantityEntity> {

    protected static final Logger logger = Logger.getLogger(QuantityAdapter.class);
    protected QuantityEntity quantity;
    protected EntityManager em;
    protected OpenfactSession session;

    public QuantityAdapter(OpenfactSession session, EntityManager em, QuantityEntity quantity) {
        this.session = session;
        this.em = em;
        this.quantity = quantity;
    }

    BigDecimal getValue() {
        return this.quantity.getValue();
    }

    void setValue(BigDecimal value) {
        this.quantity.setValue(value);
    }

    String getUnitCode() {
        return this.quantity.getUnitCode();
    }

    void setUnitCode(String value) {
        this.quantity.setUnitCode(value);
    }

    String getId() {
        return this.quantity.getId();
    }

    void setId(String value) {
        this.quantity.setId(value);
    }

}

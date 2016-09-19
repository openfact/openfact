package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;

public class MeasureAdapter implements MeasureModel, JpaModel<MeasureEntity> {

    protected static final Logger logger = Logger.getLogger(MeasureAdapter.class);
    protected MeasureEntity measure;
    protected EntityManager em;
    protected OpenfactSession session;

    public MeasureAdapter(OpenfactSession session, EntityManager em, MeasureEntity measure) {
        this.session = session;
        this.em = em;
        this.measure = measure;
    }

    BigDecimal getValue() {
        return this.measure.getValue();
    }

    void setValue(BigDecimal value) {
        this.measure.setValue(value);
    }

    String getUnitCode() {
        return this.measure.getUnitCode();
    }

    void setUnitCode(String value) {
        this.measure.setUnitCode(value);
    }

    String getId() {
        return this.measure.getId();
    }

    void setId(String value) {
        this.measure.setId(value);
    }

}

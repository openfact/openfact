package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.MeasureEntity;
import org.openfact.models.ubl.common.MeasureModel;

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

    @Override
    public BigDecimal getValue() {
        return this.measure.getValue();
    }

    @Override
    public void setValue(BigDecimal value) {
        this.measure.setValue(value);
    }

    @Override
    public String getUnitCode() {
        return this.measure.getUnitCode();
    }

    @Override
    public void setUnitCode(String value) {
        this.measure.setUnitCode(value);
    }

    @Override
    public String getId() {
        return this.measure.getId();
    }

    @Override
    public MeasureEntity getEntity() {
        return measure;
    }

    public static MeasureEntity toEntity(MeasureModel model, EntityManager em) {
        if (model instanceof MeasureAdapter) {
            return ((MeasureAdapter) model).getEntity();
        }
        return em.getReference(MeasureEntity.class, model.getId());
    }

}

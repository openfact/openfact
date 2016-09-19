package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DimensionEntity;
import org.openfact.models.ubl.common.DimensionModel;
import org.openfact.models.ubl.common.MeasureModel;

public class DimensionAdapter implements DimensionModel, JpaModel<DimensionEntity> {

    protected static final Logger logger = Logger.getLogger(DimensionAdapter.class);
    protected DimensionEntity dimension;
    protected EntityManager em;
    protected OpenfactSession session;

    public DimensionAdapter(OpenfactSession session, EntityManager em, DimensionEntity dimension) {
        this.session = session;
        this.em = em;
        this.dimension = dimension;
    }

    @Override
    public String getAttributeID() {
        return this.dimension.getAttributeID();
    }

    @Override
    public void setAttributeID(String value) {
        this.dimension.setAttributeID(value);
    }

    @Override
    public MeasureModel getMeasure() {
        return this.dimension.getMeasure();
    }

    @Override
    public void setMeasure(MeasureAdapter value) {
        this.dimension.setMeasure(value);
    }

    @Override
    public List<String> getDescription() {
        return this.dimension.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        this.dimension.setDescription(description);
    }

    @Override
    public MeasureModel getMinimumMeasure() {
        return this.dimension.getMinimumMeasure();
    }

    @Override
    public void setMinimumMeasure(MeasureAdapter value) {
        this.dimension.setMinimumMeasure(value);
    }

    @Override
    public MeasureModel getMaximumMeasure() {
        return this.dimension.getMaximumMeasure();
    }

    @Override
    public void setMaximumMeasure(MeasureAdapter value) {
        this.dimension.setMaximumMeasure(value);
    }

    @Override
    public String getId() {
        return this.dimension.getId();
    }

    @Override
    public void setId(String value) {
        this.dimension.setId(value);
    }

}

package org.openfact.models.jpa.ubl.common;

import java.util.List;

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

    String getAttributeID() {
        return this.dimension.getAttributeID();
    }

    void setAttributeID(String value) {
        this.dimension.setAttributeID(value);
    }

    MeasureAdapter getMeasure() {
        return this.dimension.getMeasure();
    }

    void setMeasure(MeasureAdapter value) {
        this.dimension.setMeasure(value);
    }

    List<String> getDescription() {
        return this.dimension.getDescription();
    }

    void setDescription(List<String> description) {
        this.dimension.setDescription(description);
    }

    MeasureAdapter getMinimumMeasure() {
        return this.dimension.getMinimumMeasure();
    }

    void setMinimumMeasure(MeasureAdapter value) {
        this.dimension.setMinimumMeasure(value);
    }

    MeasureAdapter getMaximumMeasure() {
        return this.dimension.getMaximumMeasure();
    }

    void setMaximumMeasure(MeasureAdapter value) {
        this.dimension.setMaximumMeasure(value);
    }

    String getId() {
        return this.dimension.getId();
    }

    void setId(String value) {
        this.dimension.setId(value);
    }

}

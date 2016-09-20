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
        return new MeasureAdapter(session, em, this.dimension.getMeasure());
    }

    @Override
    public void setMeasure(MeasureModel value) {
        this.dimension.setMeasure(MeasureAdapter.toEntity(value, em));
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
        return new MeasureAdapter(session, em, this.dimension.getMinimumMeasure());
    }

    @Override
    public void setMinimumMeasure(MeasureModel value) {
        this.dimension.setMinimumMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public MeasureModel getMaximumMeasure() {
        return new MeasureAdapter(session, em, this.dimension.getMaximumMeasure());
    }

    @Override
    public void setMaximumMeasure(MeasureModel value) {
        this.dimension.setMaximumMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.dimension.getId();
    }

    @Override
    public void setId(String value) {
        this.dimension.setId(value);
    }

    @Override
    public DimensionEntity getEntity() {
        return this.dimension;
    }

    public static DimensionEntity toEntity(DimensionModel model, EntityManager em) {
        // TODO Auto-generated method stub
        return null;
    }

}

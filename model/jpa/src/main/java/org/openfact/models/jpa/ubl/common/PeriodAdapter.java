package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.PeriodModel;

public class PeriodAdapter implements PeriodModel, JpaModel<PeriodEntity> {

    protected static final Logger logger = Logger.getLogger(PeriodAdapter.class);
    protected PeriodEntity period;
    protected EntityManager em;
    protected OpenfactSession session;

    public PeriodAdapter(OpenfactSession session, EntityManager em, PeriodEntity period) {
        this.session = session;
        this.em = em;
        this.period = period;
    }

    @Override
    public LocalDate getStartDate() {
        return this.period.getStartDate();
    }

    @Override
    public void setStartDate(LocalDate value) {
        this.period.setStartDate(value);
    }

    @Override
    public LocalTime getStartTime() {
        return this.period.getStartTime();
    }

    @Override
    public void setStartTime(LocalTime value) {
        this.period.setStartTime(value);
    }

    @Override
    public LocalDate getEndDate() {
        return this.period.getEndDate();
    }

    @Override
    public void setEndDate(LocalDate value) {
        this.period.setEndDate(value);
    }

    @Override
    public LocalTime getEndTime() {
        return this.period.getEndTime();
    }

    @Override
    public void setEndTime(LocalTime value) {
        this.period.setEndTime(value);
    }

    @Override
    public MeasureModel getDurationMeasure() {
        return new MeasureAdapter(session, em, this.period.getDurationMeasure());
    }

    @Override
    public void setDurationMeasure(MeasureModel value) {
        this.period.setDurationMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public List<String> getDescriptionCode() {
        return this.period.getDescriptionCode();
    }

    @Override
    public void setDescriptionCode(List<String> descriptionCode) {
        this.period.setDescriptionCode(descriptionCode);
    }

    @Override
    public List<String> getDescription() {
        return this.period.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        this.period.setDescription(description);
    }

    @Override
    public String getId() {
        return this.period.getId();
    }

    @Override
    public void setId(String value) {
        this.period.setId(value);
    }

    public static PeriodEntity toEntity(PeriodModel model, EntityManager em) {
        if (model instanceof PeriodModel) {
            return ((PeriodAdapter) model).getEntity();
        }
        return em.getReference(PeriodEntity.class, model.getId());
    }

    @Override
    public PeriodEntity getEntity() {
        return period;
    }

}

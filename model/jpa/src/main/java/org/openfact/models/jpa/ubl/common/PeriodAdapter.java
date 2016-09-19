package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

    LocalDate getStartDate() {
        return this.period.getStartDate();
    }

    void setStartDate(LocalDate value) {
        this.period.setStartDate(value);
    }

    LocalTime getStartTime() {
        return this.period.getStartTime();
    }

    void setStartTime(LocalTime value) {
        this.period.setStartTime(value);
    }

    LocalDate getEndDate() {
        return this.period.getEndDate();
    }

    void setEndDate(LocalDate value) {
        this.period.setEndDate(value);
    }

    LocalTime getEndTime() {
        return this.period.getEndTime();
    }

    void setEndTime(LocalTime value) {
        this.period.setEndTime(value);
    }

    MeasureAdapter getDurationMeasure() {
        return this.period.getDurationMeasure();
    }

    void setDurationMeasure(MeasureAdapter value) {
        this.period.setDurationMeasure(value);
    }

    List<String> getDescriptionCode() {
        return this.period.getDescriptionCode();
    }

    void setDescriptionCode(List<String> descriptionCode) {
        this.period.setDescriptionCode(descriptionCode);
    }

    List<String> getDescription() {
        return this.period.getDescription();
    }

    void setDescription(List<String> description) {
        this.period.setDescription(description);
    }

    String getId() {
        return this.period.getId();
    }

    void setId(String value) {
        this.period.setId(value);
    }

}

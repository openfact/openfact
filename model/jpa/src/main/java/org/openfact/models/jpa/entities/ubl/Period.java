package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a period of time.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:45 a. m.
 */
public class Period {

    /**
     * A description of this period, expressed as text.
     */
    private String description;
    /**
     * A description of this period, expressed as a code.
     */
    private String descriptionCode;
    /**
     * The duration of this period, expressed as an ISO 8601 code.
     */
    private BigDecimal durationMeasure;
    /**
     * The date on which this period ends.
     */
    private LocalDate endDate;
    /**
     * The time at which this period ends.
     */
    private LocalTime endTime;
    /**
     * The date on which this period begins.
     */
    private LocalDate startDate;
    /**
     * The time at which this period begins.
     */
    private LocalTime startTime;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the descriptionCode
     */
    public String getDescriptionCode() {
        return descriptionCode;
    }

    /**
     * @param descriptionCode
     *            the descriptionCode to set
     */
    public void setDescriptionCode(String descriptionCode) {
        this.descriptionCode = descriptionCode;
    }

    /**
     * @return the durationMeasure
     */
    public BigDecimal getDurationMeasure() {
        return durationMeasure;
    }

    /**
     * @param durationMeasure
     *            the durationMeasure to set
     */
    public void setDurationMeasure(BigDecimal durationMeasure) {
        this.durationMeasure = durationMeasure;
    }

    /**
     * @return the endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the endTime
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the startTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

}
package org.openfact.models.jpa.entities.ubl;

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
    private String Description;
    /**
     * A description of this period, expressed as a code.
     */
    private String DescriptionCode;
    /**
     * The duration of this period, expressed as an ISO 8601 code.
     */
    private Measure.Type DurationMeasure;
    /**
     * The date on which this period ends.
     */
    private LocalDate EndDate;
    /**
     * The time at which this period ends.
     */
    private LocalTime EndTime;
    /**
     * The date on which this period begins.
     */
    private LocalDate StartDate;
    /**
     * The time at which this period begins.
     */
    private LocalTime StartTime;

    public Period() {

    }

    public void finalize() throws Throwable {

    }

    public String getDescription() {
        return Description;
    }

    public String getDescriptionCode() {
        return DescriptionCode;
    }

    public Measure.Type getDurationMeasure() {
        return DurationMeasure;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public LocalTime getEndTime() {
        return EndTime;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public LocalTime getStartTime() {
        return StartTime;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescriptionCode(String newVal) {
        DescriptionCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDurationMeasure(Measure.Type newVal) {
        DurationMeasure = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setEndDate(LocalDate newVal) {
        EndDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setEndTime(LocalTime newVal) {
        EndTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setStartDate(LocalDate newVal) {
        StartDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setStartTime(LocalTime newVal) {
        StartTime = newVal;
    }
}// end Period
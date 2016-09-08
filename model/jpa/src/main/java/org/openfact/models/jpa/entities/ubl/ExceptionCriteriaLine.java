package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in an ExceptionCriteria document that specifies a
 * threshold for forecast variance, product activity, or performance history,
 * the exceeding of which should trigger an exception message.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:04 a. m.
 */
public class ExceptionCriteriaLine {

    /**
     * A collaboratively assigned code signifying priority of the Exception.
     * Possible values are: HIGH, LOW, MEDIUM
     */
    private String collaborationPriorityCode;
    /**
     * Coded representation of possible resolution methods". Possible values
     * are: DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
     * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
     * MANUAL_RESOLUTION MUTUALLY_DEFINED
     */
    private String exceptionResolutionCode;
    /**
     * A code signifying status specific to a shipment exception.
     */
    private String exceptionStatusCode;
    /**
     * An identifier for this exception criteria line.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * A code signifying a measure of performance.
     */
    private String performanceMetricTypeCode;
    /**
     * Establishes the criterion for one of the three types of exceptions. There
     * can be three types of exception criteria: Operational, Metric and
     * Forecast Exceptions. This will be set if this Exception is about an
     * Operational Exception. Description could be: A
     */
    private String supplyChainActivityTypeCode;

    /**
     * A quantity beyond which an exception will be triggered.
     * 
     */
    private BigDecimal thresholdQuantity;
    /**
     * Type of comparison to be carried out in reference to the set threshold."
     * Allowed values are: EXCEEDS_EXCEPTION_VALUE FALLS_BELOW_EXCEPTION_VALUE
     */
    private String thresholdValueComparisonCode;
    private List<ForecastExceptionCriterionLine> forecastExceptionCriterionLines;
    private Item supplyItem;
    private Period effectivePeriod;

    /**
     * @return the collaborationPriorityCode
     */
    public String getCollaborationPriorityCode() {
        return collaborationPriorityCode;
    }

    /**
     * @param collaborationPriorityCode
     *            the collaborationPriorityCode to set
     */
    public void setCollaborationPriorityCode(String collaborationPriorityCode) {
        this.collaborationPriorityCode = collaborationPriorityCode;
    }

    /**
     * @return the exceptionResolutionCode
     */
    public String getExceptionResolutionCode() {
        return exceptionResolutionCode;
    }

    /**
     * @param exceptionResolutionCode
     *            the exceptionResolutionCode to set
     */
    public void setExceptionResolutionCode(String exceptionResolutionCode) {
        this.exceptionResolutionCode = exceptionResolutionCode;
    }

    /**
     * @return the exceptionStatusCode
     */
    public String getExceptionStatusCode() {
        return exceptionStatusCode;
    }

    /**
     * @param exceptionStatusCode
     *            the exceptionStatusCode to set
     */
    public void setExceptionStatusCode(String exceptionStatusCode) {
        this.exceptionStatusCode = exceptionStatusCode;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the performanceMetricTypeCode
     */
    public String getPerformanceMetricTypeCode() {
        return performanceMetricTypeCode;
    }

    /**
     * @param performanceMetricTypeCode
     *            the performanceMetricTypeCode to set
     */
    public void setPerformanceMetricTypeCode(String performanceMetricTypeCode) {
        this.performanceMetricTypeCode = performanceMetricTypeCode;
    }

    /**
     * @return the supplyChainActivityTypeCode
     */
    public String getSupplyChainActivityTypeCode() {
        return supplyChainActivityTypeCode;
    }

    /**
     * @param supplyChainActivityTypeCode
     *            the supplyChainActivityTypeCode to set
     */
    public void setSupplyChainActivityTypeCode(String supplyChainActivityTypeCode) {
        this.supplyChainActivityTypeCode = supplyChainActivityTypeCode;
    }

    /**
     * @return the thresholdQuantity
     */
    public BigDecimal getThresholdQuantity() {
        return thresholdQuantity;
    }

    /**
     * @param thresholdQuantity
     *            the thresholdQuantity to set
     */
    public void setThresholdQuantity(BigDecimal thresholdQuantity) {
        this.thresholdQuantity = thresholdQuantity;
    }

    /**
     * @return the thresholdValueComparisonCode
     */
    public String getThresholdValueComparisonCode() {
        return thresholdValueComparisonCode;
    }

    /**
     * @param thresholdValueComparisonCode
     *            the thresholdValueComparisonCode to set
     */
    public void setThresholdValueComparisonCode(String thresholdValueComparisonCode) {
        this.thresholdValueComparisonCode = thresholdValueComparisonCode;
    }

    /**
     * @return the forecastExceptionCriterionLines
     */
    public List<ForecastExceptionCriterionLine> getForecastExceptionCriterionLines() {
        return forecastExceptionCriterionLines;
    }

    /**
     * @param forecastExceptionCriterionLines
     *            the forecastExceptionCriterionLines to set
     */
    public void setForecastExceptionCriterionLines(
            List<ForecastExceptionCriterionLine> forecastExceptionCriterionLines) {
        this.forecastExceptionCriterionLines = forecastExceptionCriterionLines;
    }

    /**
     * @return the supplyItem
     */
    public Item getSupplyItem() {
        return supplyItem;
    }

    /**
     * @param supplyItem
     *            the supplyItem to set
     */
    public void setSupplyItem(Item supplyItem) {
        this.supplyItem = supplyItem;
    }

    /**
     * @return the effectivePeriod
     */
    public Period getEffectivePeriod() {
        return effectivePeriod;
    }

    /**
     * @param effectivePeriod
     *            the effectivePeriod to set
     */
    public void setEffectivePeriod(Period effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }

}// end Exception Criteria Line
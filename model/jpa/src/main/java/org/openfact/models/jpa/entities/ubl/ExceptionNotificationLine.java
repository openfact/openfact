package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define a line in an Exception Notification.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:07 a. m.
 */
public class ExceptionNotificationLine {

    /**
     * Priority of Exception.
     */
    private String collaborationPriorityCode;
    /**
     * The value that was compared with the source value that resulted in the
     * exception
     */
    private BigDecimal comparedValueMeasure;
    /**
     * Text describing the exception.
     */
    private String description;
    /**
     * A code signifying status specific to a shipment exception.
     */
    private String exceptionStatusCode;
    /**
     * An identifier for this exception notification line.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * A code used to identify a measure of performance. It defines the type of
     * the Performance Metric on which an exception criteria is being defined
     */
    private String performanceMetricTypeCode;
    /**
     * Coded representation of possible resolution methods". Possible values
     * are: DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
     * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
     * MANUAL_RESOLUTION MUTUALLY_DEFINED
     */
    private String resolutionCode;
    /**
     * The value used as the basis of comparison
     */
    private BigDecimal sourceValueMeasure;
    /**
     * Establishes the criterion for one of the three types of exceptions:
     * Operational, performance metric and forecast. This reports an exception
     * notification about an operational exception. Description could be: A code
     * used to identify an operational exception
     */
    private String supplyChainActivityTypeCode;
    /**
     * The variance of a data item from an expected value during a particular
     * time interval.
     */
    private BigDecimal VarianceQuantity;
    private DocumentReference m_DocumentReference;
    private ForecastException m_ForecastException;
    private Item supplyItem;
    private Period exceptionObservationPeriod;

    public String getCollaborationPriorityCode() {
        return collaborationPriorityCode;
    }

    public void setCollaborationPriorityCode(String collaborationPriorityCode) {
        this.collaborationPriorityCode = collaborationPriorityCode;
    }

    public BigDecimal getComparedValueMeasure() {
        return comparedValueMeasure;
    }

    public void setComparedValueMeasure(BigDecimal comparedValueMeasure) {
        this.comparedValueMeasure = comparedValueMeasure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExceptionStatusCode() {
        return exceptionStatusCode;
    }

    public void setExceptionStatusCode(String exceptionStatusCode) {
        this.exceptionStatusCode = exceptionStatusCode;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPerformanceMetricTypeCode() {
        return performanceMetricTypeCode;
    }

    public void setPerformanceMetricTypeCode(String performanceMetricTypeCode) {
        this.performanceMetricTypeCode = performanceMetricTypeCode;
    }

    public String getResolutionCode() {
        return resolutionCode;
    }

    public void setResolutionCode(String resolutionCode) {
        this.resolutionCode = resolutionCode;
    }

    public BigDecimal getSourceValueMeasure() {
        return sourceValueMeasure;
    }

    public void setSourceValueMeasure(BigDecimal sourceValueMeasure) {
        this.sourceValueMeasure = sourceValueMeasure;
    }

    public String getSupplyChainActivityTypeCode() {
        return supplyChainActivityTypeCode;
    }

    public void setSupplyChainActivityTypeCode(String supplyChainActivityTypeCode) {
        this.supplyChainActivityTypeCode = supplyChainActivityTypeCode;
    }

    public BigDecimal getVarianceQuantity() {
        return VarianceQuantity;
    }

    public void setVarianceQuantity(BigDecimal varianceQuantity) {
        VarianceQuantity = varianceQuantity;
    }

    public DocumentReference getM_DocumentReference() {
        return m_DocumentReference;
    }

    public void setM_DocumentReference(DocumentReference m_DocumentReference) {
        this.m_DocumentReference = m_DocumentReference;
    }

    public ForecastException getM_ForecastException() {
        return m_ForecastException;
    }

    public void setM_ForecastException(ForecastException m_ForecastException) {
        this.m_ForecastException = m_ForecastException;
    }

    public Item getSupplyItem() {
        return supplyItem;
    }

    public void setSupplyItem(Item supplyItem) {
        this.supplyItem = supplyItem;
    }

    public Period getExceptionObservationPeriod() {
        return exceptionObservationPeriod;
    }

    public void setExceptionObservationPeriod(Period exceptionObservationPeriod) {
        this.exceptionObservationPeriod = exceptionObservationPeriod;
    }
}// end Exception Notification Line
package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to describe a meter reading.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:09 a. m.
 */
public class MeterReading {

    /**
     * Consumption in the period from PreviousMeterReadingDate to
     * LatestMeterReadingDate.
     */
    private BigDecimal DeliveredQuantity;
    /**
     * An identifier for this meter reading.
     */
    private String ID;
    /**
     * The quantity of the latest meter reading.
     */
    private BigDecimal LatestMeterQuantity;
    /**
     * The date of the latest meter reading.
     */
    private LocalDate LatestMeterReadingDate;
    /**
     * The method used for the latest meter reading, expressed as text.
     */
    private String LatestMeterReadingMethod;
    /**
     * The method used for the latest meter reading, expressed as a code.
     */
    private String LatestMeterReadingMethodCode;
    /**
     * Text containing comments on this meter reading.
     */
    private String MeterReadingComments;
    /**
     * The type of this meter reading, expressed as text.
     */
    private String MeterReadingType;
    /**
     * The type of this meter reading, expressed as a code.
     */
    private String MeterReadingTypeCode;
    /**
     * The quantity of the previous meter reading.
     */
    private BigDecimal PreviousMeterQuantity;
    /**
     * The date of the previous meter reading.
     */
    private LocalDate PreviousMeterReadingDate;
    /**
     * The method used for the previous meter reading, expressed as text.
     */
    private String PreviousMeterReadingMethod;
    /**
     * The method used for the previous meter reading, expressed as a code.
     */
    private String PreviousMeterReadingMethodCode;

    public MeterReading() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getDeliveredQuantity() {
        return DeliveredQuantity;
    }

    public String getID() {
        return ID;
    }

    public BigDecimal getLatestMeterQuantity() {
        return LatestMeterQuantity;
    }

    public LocalDate getLatestMeterReadingDate() {
        return LatestMeterReadingDate;
    }

    public String getLatestMeterReadingMethod() {
        return LatestMeterReadingMethod;
    }

    public String getLatestMeterReadingMethodCode() {
        return LatestMeterReadingMethodCode;
    }

    public String getMeterReadingComments() {
        return MeterReadingComments;
    }

    public String getMeterReadingType() {
        return MeterReadingType;
    }

    public String getMeterReadingTypeCode() {
        return MeterReadingTypeCode;
    }

    public BigDecimal getPreviousMeterQuantity() {
        return PreviousMeterQuantity;
    }

    public LocalDate getPreviousMeterReadingDate() {
        return PreviousMeterReadingDate;
    }

    public String getPreviousMeterReadingMethod() {
        return PreviousMeterReadingMethod;
    }

    public String getPreviousMeterReadingMethodCode() {
        return PreviousMeterReadingMethodCode;
    }

    /**
     * 
     * @param newVal
     */
    public void setDeliveredQuantity(BigDecimal newVal) {
        DeliveredQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLatestMeterQuantity(BigDecimal newVal) {
        LatestMeterQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLatestMeterReadingDate(LocalDate newVal) {
        LatestMeterReadingDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLatestMeterReadingMethod(String newVal) {
        LatestMeterReadingMethod = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLatestMeterReadingMethodCode(String newVal) {
        LatestMeterReadingMethodCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMeterReadingComments(String newVal) {
        MeterReadingComments = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMeterReadingType(String newVal) {
        MeterReadingType = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMeterReadingTypeCode(String newVal) {
        MeterReadingTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPreviousMeterQuantity(BigDecimal newVal) {
        PreviousMeterQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPreviousMeterReadingDate(LocalDate newVal) {
        PreviousMeterReadingDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPreviousMeterReadingMethod(String newVal) {
        PreviousMeterReadingMethod = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPreviousMeterReadingMethodCode(String newVal) {
        PreviousMeterReadingMethodCode = newVal;
    }
}// end Meter Reading
package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * The consumption for a specific party for given consumption point provided by
 * a numbers of suppliers. An enterprise can have one utility statement for
 * several parties (e.g. a ministry of defence receiving a telephone bill). In
 * this way each subscriber cons
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:57 a. m.
 */
public class SubscriberConsumption {

    /**
     * The identifier tor this specification.
     */
    private String ConsumptionID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * The code which specifies the type of this specification, e.g. an on
     * account specification or the yearly specification.
     */
    private String SpecificationTypeCode;
    /**
     * The total quantity consumed, as calculated from meter readings.
     */
    private BigDecimal TotalMeteredQuantity;
    private Consumption m_Consumption;
    private ConsumptionPoint UtilityConsumptionPoint;
    private OnAccountPayment m_OnAccountPayment;
    private Party SubscriberParty;
    private SupplierConsumption m_SupplierConsumption;

    public SubscriberConsumption() {

    }

    public void finalize() throws Throwable {

    }

    public Consumption getConsumption() {
        return m_Consumption;
    }

    public String getConsumptionID() {
        return ConsumptionID;
    }

    public String getNote() {
        return Note;
    }

    public OnAccountPayment getOnAccountPayment() {
        return m_OnAccountPayment;
    }

    public String getSpecificationTypeCode() {
        return SpecificationTypeCode;
    }

    public Party getSubscriberParty() {
        return SubscriberParty;
    }

    public SupplierConsumption getSupplierConsumption() {
        return m_SupplierConsumption;
    }

    public BigDecimal getTotalMeteredQuantity() {
        return TotalMeteredQuantity;
    }

    public ConsumptionPoint getUtilityConsumptionPoint() {
        return UtilityConsumptionPoint;
    }

    /**
     * 
     * @param newVal
     */
    public void setConsumption(Consumption newVal) {
        m_Consumption = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConsumptionID(String newVal) {
        ConsumptionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(String newVal) {
        Note = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOnAccountPayment(OnAccountPayment newVal) {
        m_OnAccountPayment = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSpecificationTypeCode(String newVal) {
        SpecificationTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSubscriberParty(Party newVal) {
        SubscriberParty = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSupplierConsumption(SupplierConsumption newVal) {
        m_SupplierConsumption = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTotalMeteredQuantity(BigDecimal newVal) {
        TotalMeteredQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUtilityConsumptionPoint(ConsumptionPoint newVal) {
        UtilityConsumptionPoint = newVal;
    }
}// end SubscriberConsumption
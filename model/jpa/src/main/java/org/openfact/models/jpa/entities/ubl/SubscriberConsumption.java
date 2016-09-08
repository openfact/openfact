package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
    private List<Consumption> consumptions = new ArrayList<>();
    private ConsumptionPoint UtilityConsumptionPoint;
    private List<OnAccountPayment> onAccountPayments = new ArrayList<>();
    private Party SubscriberParty;
    private List<SupplierConsumption> supplierConsumptions = new ArrayList<>();

    /**
     * @return the consumptionID
     */
    public String getConsumptionID() {
        return ConsumptionID;
    }

    /**
     * @param consumptionID
     *            the consumptionID to set
     */
    public void setConsumptionID(String consumptionID) {
        ConsumptionID = consumptionID;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the specificationTypeCode
     */
    public String getSpecificationTypeCode() {
        return SpecificationTypeCode;
    }

    /**
     * @param specificationTypeCode
     *            the specificationTypeCode to set
     */
    public void setSpecificationTypeCode(String specificationTypeCode) {
        SpecificationTypeCode = specificationTypeCode;
    }

    /**
     * @return the totalMeteredQuantity
     */
    public BigDecimal getTotalMeteredQuantity() {
        return TotalMeteredQuantity;
    }

    /**
     * @param totalMeteredQuantity
     *            the totalMeteredQuantity to set
     */
    public void setTotalMeteredQuantity(BigDecimal totalMeteredQuantity) {
        TotalMeteredQuantity = totalMeteredQuantity;
    }

    /**
     * @return the consumptions
     */
    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    /**
     * @param consumptions
     *            the consumptions to set
     */
    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    /**
     * @return the utilityConsumptionPoint
     */
    public ConsumptionPoint getUtilityConsumptionPoint() {
        return UtilityConsumptionPoint;
    }

    /**
     * @param utilityConsumptionPoint
     *            the utilityConsumptionPoint to set
     */
    public void setUtilityConsumptionPoint(ConsumptionPoint utilityConsumptionPoint) {
        UtilityConsumptionPoint = utilityConsumptionPoint;
    }

    /**
     * @return the onAccountPayments
     */
    public List<OnAccountPayment> getOnAccountPayments() {
        return onAccountPayments;
    }

    /**
     * @param onAccountPayments
     *            the onAccountPayments to set
     */
    public void setOnAccountPayments(List<OnAccountPayment> onAccountPayments) {
        this.onAccountPayments = onAccountPayments;
    }

    /**
     * @return the subscriberParty
     */
    public Party getSubscriberParty() {
        return SubscriberParty;
    }

    /**
     * @param subscriberParty
     *            the subscriberParty to set
     */
    public void setSubscriberParty(Party subscriberParty) {
        SubscriberParty = subscriberParty;
    }

    /**
     * @return the supplierConsumptions
     */
    public List<SupplierConsumption> getSupplierConsumptions() {
        return supplierConsumptions;
    }

    /**
     * @param supplierConsumptions
     *            the supplierConsumptions to set
     */
    public void setSupplierConsumptions(List<SupplierConsumption> supplierConsumptions) {
        this.supplierConsumptions = supplierConsumptions;
    }

}// end SubscriberConsumption
package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class for describing the terms and conditions applying to the delivery of
 * goods.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:23 a. m.
 */
public class DeliveryTerms {

    /**
     * The monetary amount covered by these delivery terms.
     */
    private BigDecimal amount;
    /**
     * An identifier for this description of delivery terms.
     */
    private String ID;
    /**
     * A description of responsibility for risk of loss in execution of the
     * delivery, expressed as text.
     */
    private String lossRisk;
    /**
     * A code that identifies one of various responsibilities for loss risk in
     * the execution of the delivery.
     */
    private String lossRiskResponsibilityCode;
    /**
     * A description of any terms or conditions relating to the delivery items.
     */
    private String specialTerms;
    private AllowanceCharge m_AllowanceCharge;
    private Location deliveryLocation;

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * @return the lossRisk
     */
    public String getLossRisk() {
        return lossRisk;
    }

    /**
     * @param lossRisk
     *            the lossRisk to set
     */
    public void setLossRisk(String lossRisk) {
        this.lossRisk = lossRisk;
    }

    /**
     * @return the lossRiskResponsibilityCode
     */
    public String getLossRiskResponsibilityCode() {
        return lossRiskResponsibilityCode;
    }

    /**
     * @param lossRiskResponsibilityCode
     *            the lossRiskResponsibilityCode to set
     */
    public void setLossRiskResponsibilityCode(String lossRiskResponsibilityCode) {
        this.lossRiskResponsibilityCode = lossRiskResponsibilityCode;
    }

    /**
     * @return the specialTerms
     */
    public String getSpecialTerms() {
        return specialTerms;
    }

    /**
     * @param specialTerms
     *            the specialTerms to set
     */
    public void setSpecialTerms(String specialTerms) {
        this.specialTerms = specialTerms;
    }

    /**
     * @return the m_AllowanceCharge
     */
    public AllowanceCharge getM_AllowanceCharge() {
        return m_AllowanceCharge;
    }

    /**
     * @param m_AllowanceCharge
     *            the m_AllowanceCharge to set
     */
    public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
        this.m_AllowanceCharge = m_AllowanceCharge;
    }

    /**
     * @return the deliveryLocation
     */
    public Location getDeliveryLocation() {
        return deliveryLocation;
    }

    /**
     * @param deliveryLocation
     *            the deliveryLocation to set
     */
    public void setDeliveryLocation(Location deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

}// end DeliveryTerms
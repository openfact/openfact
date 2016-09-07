package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class that outlines the telecommunication supply in details
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:11 a. m.
 */
public class TelecommunicationsSupplyLine {

    /**
     * The description of the telecommunication supply line
     */
    private String Description;
    /**
     * An identifier for this telecommunications supply line.
     */
    private String ID;
    /**
     * An amount specifying the cost of this telecommunication line
     */
    private BigDecimal LineExtensionAmount;
    /**
     * The phone number used for this telecommunication supply line
     */
    private String PhoneNumber;
    private AllowanceCharge m_AllowanceCharge;
    private ExchangeRate m_ExchangeRate;
    private TaxTotal m_TaxTotal;
    private TelecommunicationsService m_TelecommunicationsService;

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
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
     * @return the lineExtensionAmount
     */
    public BigDecimal getLineExtensionAmount() {
        return LineExtensionAmount;
    }

    /**
     * @param lineExtensionAmount
     *            the lineExtensionAmount to set
     */
    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        LineExtensionAmount = lineExtensionAmount;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param phoneNumber
     *            the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
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
     * @return the m_ExchangeRate
     */
    public ExchangeRate getM_ExchangeRate() {
        return m_ExchangeRate;
    }

    /**
     * @param m_ExchangeRate
     *            the m_ExchangeRate to set
     */
    public void setM_ExchangeRate(ExchangeRate m_ExchangeRate) {
        this.m_ExchangeRate = m_ExchangeRate;
    }

    /**
     * @return the m_TaxTotal
     */
    public TaxTotal getM_TaxTotal() {
        return m_TaxTotal;
    }

    /**
     * @param m_TaxTotal
     *            the m_TaxTotal to set
     */
    public void setM_TaxTotal(TaxTotal m_TaxTotal) {
        this.m_TaxTotal = m_TaxTotal;
    }

    /**
     * @return the m_TelecommunicationsService
     */
    public TelecommunicationsService getM_TelecommunicationsService() {
        return m_TelecommunicationsService;
    }

    /**
     * @param m_TelecommunicationsService
     *            the m_TelecommunicationsService to set
     */
    public void setM_TelecommunicationsService(TelecommunicationsService m_TelecommunicationsService) {
        this.m_TelecommunicationsService = m_TelecommunicationsService;
    }

}// end TelecommunicationsSupplyLine
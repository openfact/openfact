package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
    private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
    private List<TaxTotal> taxTotals = new ArrayList<>();
    private List<TelecommunicationsService> telecommunicationsServices = new ArrayList<>();

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
     * @return the allowanceCharges
     */
    public List<AllowanceCharge> getAllowanceCharges() {
        return allowanceCharges;
    }

    /**
     * @param allowanceCharges
     *            the allowanceCharges to set
     */
    public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    /**
     * @return the exchangeRates
     */
    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    /**
     * @param exchangeRates
     *            the exchangeRates to set
     */
    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    /**
     * @return the taxTotals
     */
    public List<TaxTotal> getTaxTotals() {
        return taxTotals;
    }

    /**
     * @param taxTotals
     *            the taxTotals to set
     */
    public void setTaxTotals(List<TaxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }

    /**
     * @return the telecommunicationsServices
     */
    public List<TelecommunicationsService> getTelecommunicationsServices() {
        return telecommunicationsServices;
    }

    /**
     * @param telecommunicationsServices
     *            the telecommunicationsServices to set
     */
    public void setTelecommunicationsServices(List<TelecommunicationsService> telecommunicationsServices) {
        this.telecommunicationsServices = telecommunicationsServices;
    }

}
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
    private String description;
    /**
     * An identifier for this telecommunications supply line.
     */
    private String id;
    /**
     * An amount specifying the cost of this telecommunication line
     */
    private BigDecimal lineExtensionAmount;
    /**
     * The phone number used for this telecommunication supply line
     */
    private String phoneNumber;
    private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
    private List<TaxTotal> taxTotals = new ArrayList<>();
    private List<TelecommunicationsService> telecommunicationsServices = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<AllowanceCharge> getAllowanceCharges() {
        return allowanceCharges;
    }

    public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public List<TaxTotal> getTaxTotals() {
        return taxTotals;
    }

    public void setTaxTotals(List<TaxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }

    public List<TelecommunicationsService> getTelecommunicationsServices() {
        return telecommunicationsServices;
    }

    public void setTelecommunicationsServices(List<TelecommunicationsService> telecommunicationsServices) {
        this.telecommunicationsServices = telecommunicationsServices;
    }
}
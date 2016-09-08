package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a telecommunications service (e.g., a telephone call or a
 * video on demand service).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:09 a. m.
 */
public class TelecommunicationsService {

    /**
     * The amount to be payed as the base for one call
     */
    private BigDecimal callBaseAmount;
    /**
     * In the case of a telephone call, the date of the call.
     */
    private LocalDate callDate;
    /**
     * The amount to be payed for the call
     */
    private BigDecimal callExtensionAmount;
    /**
     * In the case of a telephone call, the time of the call.
     */
    private LocalTime callTime;
    /**
     * An identifier for this telecommunications service.
     */
    private String id;
    /**
     * The title of a movie delivered via this telecommunications service.
     */
    private String movieTitle;
    /**
     * A pay-per-view delivered via this telecommunications service.
     */
    private String payPerView;
    /**
     * The number of calls.
     */
    private BigDecimal quantity;
    /**
     * Statement of the roaming partner name.
     */
    private String roamingPartnerName;
    /**
     * In the case of a telephone call, the phone number called.
     */
    private String serviceNumberCalled;
    /**
     * The telecommunications call described as a text
     */
    private String telecommunicationsServiceCall;
    /**
     * The telecommunications call described as a code
     */
    private String telecommunicationsServiceCallCode;
    /**
     * The telecommunications category, expressed as text.
     */
    private String telecommunicationsServiceCategory;
    /**
     * The telecommunications category, expressed as a code.
     */
    private String telecommunicationsServiceCategoryCode;
    private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();
    private Duty CallDuty;
    private Duty TimeDuty;
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
    private List<Price> prices = new ArrayList<>();
    private List<TaxTotal> taxTotals = new ArrayList<>();

    public BigDecimal getCallBaseAmount() {
        return callBaseAmount;
    }

    public void setCallBaseAmount(BigDecimal callBaseAmount) {
        this.callBaseAmount = callBaseAmount;
    }

    public LocalDate getCallDate() {
        return callDate;
    }

    public void setCallDate(LocalDate callDate) {
        this.callDate = callDate;
    }

    public BigDecimal getCallExtensionAmount() {
        return callExtensionAmount;
    }

    public void setCallExtensionAmount(BigDecimal callExtensionAmount) {
        this.callExtensionAmount = callExtensionAmount;
    }

    public LocalTime getCallTime() {
        return callTime;
    }

    public void setCallTime(LocalTime callTime) {
        this.callTime = callTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPayPerView() {
        return payPerView;
    }

    public void setPayPerView(String payPerView) {
        this.payPerView = payPerView;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRoamingPartnerName() {
        return roamingPartnerName;
    }

    public void setRoamingPartnerName(String roamingPartnerName) {
        this.roamingPartnerName = roamingPartnerName;
    }

    public String getServiceNumberCalled() {
        return serviceNumberCalled;
    }

    public void setServiceNumberCalled(String serviceNumberCalled) {
        this.serviceNumberCalled = serviceNumberCalled;
    }

    public String getTelecommunicationsServiceCall() {
        return telecommunicationsServiceCall;
    }

    public void setTelecommunicationsServiceCall(String telecommunicationsServiceCall) {
        this.telecommunicationsServiceCall = telecommunicationsServiceCall;
    }

    public String getTelecommunicationsServiceCallCode() {
        return telecommunicationsServiceCallCode;
    }

    public void setTelecommunicationsServiceCallCode(String telecommunicationsServiceCallCode) {
        this.telecommunicationsServiceCallCode = telecommunicationsServiceCallCode;
    }

    public String getTelecommunicationsServiceCategory() {
        return telecommunicationsServiceCategory;
    }

    public void setTelecommunicationsServiceCategory(String telecommunicationsServiceCategory) {
        this.telecommunicationsServiceCategory = telecommunicationsServiceCategory;
    }

    public String getTelecommunicationsServiceCategoryCode() {
        return telecommunicationsServiceCategoryCode;
    }

    public void setTelecommunicationsServiceCategoryCode(String telecommunicationsServiceCategoryCode) {
        this.telecommunicationsServiceCategoryCode = telecommunicationsServiceCategoryCode;
    }

    public List<AllowanceCharge> getAllowanceCharges() {
        return allowanceCharges;
    }

    public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Duty getCallDuty() {
        return CallDuty;
    }

    public void setCallDuty(Duty callDuty) {
        CallDuty = callDuty;
    }

    public Duty getTimeDuty() {
        return TimeDuty;
    }

    public void setTimeDuty(Duty timeDuty) {
        TimeDuty = timeDuty;
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<TaxTotal> getTaxTotals() {
        return taxTotals;
    }

    public void setTaxTotals(List<TaxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }
}
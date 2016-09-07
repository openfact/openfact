package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define an exchange rate.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:08 a. m.
 */
public class ExchangeRate {

    /**
     * The factor applied to the source currency to calculate the target
     * currency.
     */
    private BigDecimal calculationRate;
    /**
     * The date on which the exchange rate was established.
     */
    private LocalDate date;
    /**
     * An identifier for the currency exchange market used as the source of this
     * exchange rate.
     */
    private String exchangeMarketID;
    /**
     * A code signifying whether the calculation rate is a multiplier or a
     * divisor.
     */
    private String mathematicOperatorCode;
    /**
     * In the case of a source currency with denominations of small value, the
     * unit base.
     */
    private BigDecimal sourceCurrencyBaseRate;
    /**
     * The reference currency for this exchange rate; the currency from which
     * the exchange is being made.
     */
    private String sourceCurrencyCode;
    /**
     * In the case of a target currency with denominations of small value, the
     * unit base.
     */
    private BigDecimal targetCurrencyBaseRate;
    /**
     * The target currency for this exchange rate; the currency to which the
     * exchange is being made.
     */
    private String targetCurrencyCode;

    private Contract foreignExchangeContract;

    /**
     * @return the calculationRate
     */
    public BigDecimal getCalculationRate() {
        return calculationRate;
    }

    /**
     * @param calculationRate
     *            the calculationRate to set
     */
    public void setCalculationRate(BigDecimal calculationRate) {
        this.calculationRate = calculationRate;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the exchangeMarketID
     */
    public String getExchangeMarketID() {
        return exchangeMarketID;
    }

    /**
     * @param exchangeMarketID
     *            the exchangeMarketID to set
     */
    public void setExchangeMarketID(String exchangeMarketID) {
        this.exchangeMarketID = exchangeMarketID;
    }

    /**
     * @return the mathematicOperatorCode
     */
    public String getMathematicOperatorCode() {
        return mathematicOperatorCode;
    }

    /**
     * @param mathematicOperatorCode
     *            the mathematicOperatorCode to set
     */
    public void setMathematicOperatorCode(String mathematicOperatorCode) {
        this.mathematicOperatorCode = mathematicOperatorCode;
    }

    /**
     * @return the sourceCurrencyBaseRate
     */
    public BigDecimal getSourceCurrencyBaseRate() {
        return sourceCurrencyBaseRate;
    }

    /**
     * @param sourceCurrencyBaseRate
     *            the sourceCurrencyBaseRate to set
     */
    public void setSourceCurrencyBaseRate(BigDecimal sourceCurrencyBaseRate) {
        this.sourceCurrencyBaseRate = sourceCurrencyBaseRate;
    }

    /**
     * @return the sourceCurrencyCode
     */
    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    /**
     * @param sourceCurrencyCode
     *            the sourceCurrencyCode to set
     */
    public void setSourceCurrencyCode(String sourceCurrencyCode) {
        this.sourceCurrencyCode = sourceCurrencyCode;
    }

    /**
     * @return the targetCurrencyBaseRate
     */
    public BigDecimal getTargetCurrencyBaseRate() {
        return targetCurrencyBaseRate;
    }

    /**
     * @param targetCurrencyBaseRate
     *            the targetCurrencyBaseRate to set
     */
    public void setTargetCurrencyBaseRate(BigDecimal targetCurrencyBaseRate) {
        this.targetCurrencyBaseRate = targetCurrencyBaseRate;
    }

    /**
     * @return the targetCurrencyCode
     */
    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    /**
     * @param targetCurrencyCode
     *            the targetCurrencyCode to set
     */
    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }

    /**
     * @return the foreignExchangeContract
     */
    public Contract getForeignExchangeContract() {
        return foreignExchangeContract;
    }

    /**
     * @param foreignExchangeContract
     *            the foreignExchangeContract to set
     */
    public void setForeignExchangeContract(Contract foreignExchangeContract) {
        this.foreignExchangeContract = foreignExchangeContract;
    }

}// end Exchange Rate
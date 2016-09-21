//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "EXCHANGERATE")
public class ExchangeRateEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "SOURCE_CURRENCY_CODE")
    protected String sourceCurrencyCode;

    @Column(name = "SOURCE_CURRENCY_BASE_RATE")
    protected BigDecimal sourceCurrencyBaseRate;

    @Column(name = "TARGET_CURRENCY_CODE")
    protected String targetCurrencyCode;

    @Column(name = "TARGET_CURRENCY_BASE_RATE")
    protected BigDecimal targetCurrencyBaseRate;

    @Column(name = "EXCHANGE_MARKET_ID")
    protected String exchangeMarketID;

    @Column(name = "CALCULATION_RATE")
    protected BigDecimal calculationRate;

    @Column(name = "MATHEMATIC_OPERATOR_CODE")
    protected String mathematicOperatorCode;

    @Column(name = "DATE")
    @Type(type = "LocalDate, java.time.LocalDate")
    protected LocalDate date;

    @ManyToOne(targetEntity = ContractEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FOREIGNEXCHANGECONTRACT")
    protected ContractEntity foreignExchangeContract = new ContractEntity();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the foreignExchangeContract
     */
    public ContractEntity getForeignExchangeContract() {
        return foreignExchangeContract;
    }

    /**
     * @param foreignExchangeContract
     *            the foreignExchangeContract to set
     */
    public void setForeignExchangeContract(ContractEntity foreignExchangeContract) {
        this.foreignExchangeContract = foreignExchangeContract;
    }

}

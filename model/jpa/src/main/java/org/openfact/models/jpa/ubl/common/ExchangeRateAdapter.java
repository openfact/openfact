package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateAdapter implements ExchangeRateModel, JpaModel<ExchangeRateEntity> {

    protected static final Logger logger = Logger.getLogger(ExchangeRateAdapter.class);
    protected ExchangeRateEntity exchangeRate;
    protected EntityManager em;
    protected OpenfactSession session;

    public ExchangeRateAdapter(OpenfactSession session, EntityManager em, ExchangeRateEntity exchangeRate) {
        this.session = session;
        this.em = em;
        this.exchangeRate = exchangeRate;
    }

    String getSourceCurrencyCode() {
        return this.exchangeRate.getSourceCurrencyCode();
    }

    void setSourceCurrencyCode(String value) {
        this.exchangeRate.setSourceCurrencyCode(value);
    }

    BigDecimal getSourceCurrencyBaseRate() {
        return this.exchangeRate.getSourceCurrencyBaseRate();
    }

    void setSourceCurrencyBaseRate(BigDecimal value) {
        this.exchangeRate.setSourceCurrencyBaseRate(value);
    }

    String getTargetCurrencyCode() {
        return this.exchangeRate.getTargetCurrencyCode();
    }

    void setTargetCurrencyCode(String value) {
        this.exchangeRate.setTargetCurrencyCode(value);
    }

    BigDecimal getTargetCurrencyBaseRate() {
        return this.exchangeRate.getTargetCurrencyBaseRate();
    }

    void setTargetCurrencyBaseRate(BigDecimal value) {
        this.exchangeRate.setTargetCurrencyBaseRate(value);
    }

    String getExchangeMarketID() {
        return this.exchangeRate.getExchangeMarketID();
    }

    void setExchangeMarketID(String value) {
        this.exchangeRate.setExchangeMarketID(value);
    }

    BigDecimal getCalculationRate() {
        return this.exchangeRate.getCalculationRate();
    }

    void setCalculationRate(BigDecimal value) {
        this.exchangeRate.setCalculationRate(value);
    }

    String getMathematicOperatorCode() {
        return this.exchangeRate.getMathematicOperatorCode();
    }

    void setMathematicOperatorCode(String value) {
        this.exchangeRate.setMathematicOperatorCode(value);
    }

    LocalDate getDate() {
        return this.exchangeRate.getDate();
    }

    void setDate(LocalDate value) {
        this.exchangeRate.setDate(value);
    }

    ContractAdapter getForeignExchangeContract() {
        return this.exchangeRate.getForeignExchangeContract();
    }

    void setForeignExchangeContract(ContractAdapter value) {
        this.exchangeRate.setForeignExchangeContract(value);
    }

    String getId() {
        return this.exchangeRate.getId();
    }

    void setId(String value) {
        this.exchangeRate.setId(value);
    }

}

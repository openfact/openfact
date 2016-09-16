package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExchangeRateModel {

    String getSourceCurrencyCode();

    void setSourceCurrencyCode(String value);

    BigDecimal getSourceCurrencyBaseRate();

    void setSourceCurrencyBaseRate(BigDecimal value);

    String getTargetCurrencyCode();

    void setTargetCurrencyCode(String value);

    BigDecimal getTargetCurrencyBaseRate();

    void setTargetCurrencyBaseRate(BigDecimal value);

    String getExchangeMarketID();

    void setExchangeMarketID(String value);

    BigDecimal getCalculationRate();

    void setCalculationRate(BigDecimal value);

    String getMathematicOperatorCode();

    void setMathematicOperatorCode(String value);

    LocalDate getDate();

    void setDate(LocalDate value);

    ContractModel getForeignExchangeContract();

    void setForeignExchangeContract(ContractModel value);

    String getId();

    void setId(String value);

}

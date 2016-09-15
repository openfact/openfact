package org.openfact.models.ubl.common;

public interface ExchangeRateModel {

    String getSourceCurrencyCode();

    void setSourceCurrencyCode(String value);

    SourceCurrencyBaseRateModel getSourceCurrencyBaseRate();

    void setSourceCurrencyBaseRate(SourceCurrencyBaseRateModel value);

    String getTargetCurrencyCode();

    void setTargetCurrencyCode(String value);

    TargetCurrencyBaseRateModel getTargetCurrencyBaseRate();

    void setTargetCurrencyBaseRate(TargetCurrencyBaseRateModel value);

    ExchangeMarketIDModel getExchangeMarketID();

    void setExchangeMarketID(ExchangeMarketIDModel value);

    CalculationRateModel getCalculationRate();

    void setCalculationRate(CalculationRateModel value);

    String getMathematicOperatorCode();

    void setMathematicOperatorCode(String value);

    DateModel getDate();

    void setDate(DateModel value);

    ContractModel getForeignExchangeContract();

    void setForeignExchangeContract(ContractModel value);

    String getId();

    void setId(String value);

}

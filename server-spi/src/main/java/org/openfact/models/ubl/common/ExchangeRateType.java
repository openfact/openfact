package org.openfact.models.ubl.common;

public interface ExchangeRateType {

    SourceCurrencyCodeType getSourceCurrencyCode();

    void setSourceCurrencyCode(SourceCurrencyCodeType value);

    SourceCurrencyBaseRateType getSourceCurrencyBaseRate();

    void setSourceCurrencyBaseRate(SourceCurrencyBaseRateType value);

    TargetCurrencyCodeType getTargetCurrencyCode();

    void setTargetCurrencyCode(TargetCurrencyCodeType value);

    TargetCurrencyBaseRateType getTargetCurrencyBaseRate();

    void setTargetCurrencyBaseRate(TargetCurrencyBaseRateType value);

    ExchangeMarketIDType getExchangeMarketID();

    void setExchangeMarketID(ExchangeMarketIDType value);

    CalculationRateType getCalculationRate();

    void setCalculationRate(CalculationRateType value);

    MathematicOperatorCodeType getMathematicOperatorCode();

    void setMathematicOperatorCode(MathematicOperatorCodeType value);

    DateType getDate();

    void setDate(DateType value);

    ContractType getForeignExchangeContract();

    void setForeignExchangeContract(ContractType value);

    String getId();

    void setId(String value);

}

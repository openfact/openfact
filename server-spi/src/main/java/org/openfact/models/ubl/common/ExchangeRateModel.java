package org.openfact.models.ubl.common;

public interface ExchangeRateModel {

    SourceCurrencyCodeModel getSourceCurrencyCode();

    void setSourceCurrencyCode(SourceCurrencyCodeModel value);

    SourceCurrencyBaseRateModel getSourceCurrencyBaseRate();

    void setSourceCurrencyBaseRate(SourceCurrencyBaseRateModel value);

    TargetCurrencyCodeModel getTargetCurrencyCode();

    void setTargetCurrencyCode(TargetCurrencyCodeModel value);

    TargetCurrencyBaseRateModel getTargetCurrencyBaseRate();

    void setTargetCurrencyBaseRate(TargetCurrencyBaseRateModel value);

    ExchangeMarketIDModel getExchangeMarketID();

    void setExchangeMarketID(ExchangeMarketIDModel value);

    CalculationRateModel getCalculationRate();

    void setCalculationRate(CalculationRateModel value);

    MathematicOperatorCodeModel getMathematicOperatorCode();

    void setMathematicOperatorCode(MathematicOperatorCodeModel value);

    DateModel getDate();

    void setDate(DateModel value);

    ContractModel getForeignExchangeContract();

    void setForeignExchangeContract(ContractModel value);

    String getId();

    void setId(String value);

}

package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateModel {
    protected String SourceCurrencyCode;
    protected BigDecimal SourceCurrencyBaseRate;
    protected String TargetCurrencyCode;
    protected BigDecimal TargetCurrencyBaseRate;
    protected String ExchangeMarketID;
    protected BigDecimal CalculationRate;
    protected String MathematicOperatorCode;
    protected LocalDate Date;
    protected ContractModel ForeignExchangeContract;
    protected String Id;
}
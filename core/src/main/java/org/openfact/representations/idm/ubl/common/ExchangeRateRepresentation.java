package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateRepresentation {
    private String SourceCurrencyCode;
    private BigDecimal SourceCurrencyBaseRate;
    private String TargetCurrencyCode;
    private BigDecimal TargetCurrencyBaseRate;
    private String ExchangeMarketID;
    private BigDecimal CalculationRate;
    private String MathematicOperatorCode;
    private LocalDate Date;
    private ContractRepresentation ForeignExchangeContract;
    private String Id;
}
package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateRepresentation {
    private String sourceCurrencyCode;
    private BigDecimal sourceCurrencyBaseRate;
    private String targetCurrencyCode;
    private BigDecimal targetCurrencyBaseRate;
    private String exchangeMarketID;
    private BigDecimal calculationRate;
    private String mathematicOperatorCode;
    private LocalDate date;
    private ContractRepresentation foreignExchangeContract;
    private String id;
}

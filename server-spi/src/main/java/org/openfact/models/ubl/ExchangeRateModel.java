package org.openfact.models.ubl;

import java.time.LocalDate;

import org.openfact.models.ubl.type.*;

/**
 * A class to define an exchange rate.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:08 a. m.
 */
public class ExchangeRateModel {

    /**
     * The factor applied to the source currency to calculate the target
     * currency.
     */
    private RateModel calculationRate;
    /**
     * The date on which the exchange rate was established.
     */
    private LocalDate date;
    /**
     * An identifier for the currency exchange market used as the source of this
     * exchange rate.
     */
    private IdentifierModel exchangeMarketID;
    /**
     * A code signifying whether the calculation rate is a multiplier or a
     * divisor.
     */
    private OperatorCodeModel mathematicOperatorCode;
    /**
     * In the case of a source currency with denominations of small value, the
     * unit base.
     */
    private RateModel sourceCurrencyBaseRate;
    /**
     * The reference currency for this exchange rate; the currency from which
     * the exchange is being made.
     */
    private CurrencyCodeModel codeTypeSourceCurrencyCode;
    /**
     * In the case of a target currency with denominations of small value, the
     * unit base.
     */
    private RateModel targetCurrencyBaseRate;
    /**
     * The target currency for this exchange rate; the currency to which the
     * exchange is being made.
     */
    private CurrencyCodeModel codeTypeTargetCurrencyCode;
    private ContractModel foreignExchangeContract;

}

package org.openfact.representations.idm.ubl;

import java.time.LocalDate;

import org.openfact.representations.idm.ubl.type.CurrencyCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.OperatorCodeRepresentation;
import org.openfact.representations.idm.ubl.type.RateRepresentation;

/**
 * A class to define an exchange rate.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:08 a. m.
 */
public class ExchangeRateRepresentation {

    /**
     * The factor applied to the source currency to calculate the target
     * currency.
     */
    private RateRepresentation calculationRate;
    /**
     * The date on which the exchange rate was established.
     */
    private LocalDate date;
    /**
     * An identifier for the currency exchange market used as the source of this
     * exchange rate.
     */
    private IdentifierRepresentation exchangeMarketID;
    /**
     * A code signifying whether the calculation rate is a multiplier or a
     * divisor.
     */
    private OperatorCodeRepresentation mathematicOperatorCode;
    /**
     * In the case of a source currency with denominations of small value, the
     * unit base.
     */
    private RateRepresentation sourceCurrencyBaseRate;
    /**
     * The reference currency for this exchange rate; the currency from which
     * the exchange is being made.
     */
    private CurrencyCodeRepresentation codeTypeSourceCurrencyCode;
    /**
     * In the case of a target currency with denominations of small value, the
     * unit base.
     */
    private RateRepresentation targetCurrencyBaseRate;
    /**
     * The target currency for this exchange rate; the currency to which the
     * exchange is being made.
     */
    private CurrencyCodeRepresentation codeTypeTargetCurrencyCode;
    private ContractRepresentation foreignExchangeContract;

}

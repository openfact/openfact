package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define an exchange rate.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:08 a. m.
 */
public class ExchangeRateEntity{

	/**
	 * The factor applied to the source currency to calculate the target currency.
	 */
	private RateType calculationRate; 
	/**
	 * The date on which the exchange rate was established.
	 */
	private DateType date; 
	/**
	 * An identifier for the currency exchange market used as the source of this
	 * exchange rate.
	 */
	private IdentifierType exchangeMarketID; 
	/**
	 * A code signifying whether the calculation rate is a multiplier or a divisor.
	 */
	private OperatorCodeType mathematicOperatorCode; 
	/**
	 * In the case of a source currency with denominations of small value, the unit
	 * base.
	 */
	private RateType sourceCurrencyBaseRate; 
	/**
	 * The reference currency for this exchange rate; the currency from which the
	 * exchange is being made.
	 */
	private CurrencyCodeType codeTypeSourceCurrencyCode; 
	/**
	 * In the case of a target currency with denominations of small value, the unit
	 * base.
	 */
	private RateType targetCurrencyBaseRate; 
	/**
	 * The target currency for this exchange rate; the currency to which the exchange
	 * is being made.
	 */
	private CurrencyCodeType codeTypeTargetCurrencyCode; 
	private ContractEntity foreignExchangeContract; 

}

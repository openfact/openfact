package org.openfact.models.jpa.entities.ubl;


import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define an exchange rate.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:08 a. m.
 */
public class ExchangeRate {

	/**
	 * The factor applied to the source currency to calculate the target currency.
	 */
	private BigDecimal calculationRate;
	/**
	 * The date on which the exchange rate was established.
	 */
	private LocalDate date;
	/**
	 * An identifier for the currency exchange market used as the source of this
	 * exchange rate.
	 */
	private String exchangeMarketID;
	/**
	 * A code signifying whether the calculation rate is a multiplier or a divisor.
	 */
	private String mathematicOperatorCode;
	/**
	 * In the case of a source currency with denominations of small value, the unit
	 * base.
	 */
	private BigDecimal sourceCurrencyBaseRate;
	/**
	 * The reference currency for this exchange rate; the currency from which the
	 * exchange is being made.
	 */
	private String sourceCurrencyCode;
	/**
	 * In the case of a target currency with denominations of small value, the unit
	 * base.
	 */
	private BigDecimal targetCurrencyBaseRate;
	/**
	 * The target currency for this exchange rate; the currency to which the exchange
	 * is being made.
	 */
	private String targetCurrencyCode;

	public Contract getForeignExchangeContract() {
		return foreignExchangeContract;
	}

	public void setForeignExchangeContract(Contract foreignExchangeContract) {
		this.foreignExchangeContract = foreignExchangeContract;
	}

	public BigDecimal getCalculationRate() {
		return calculationRate;
	}

	public void setCalculationRate(BigDecimal calculationRate) {
		this.calculationRate = calculationRate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getExchangeMarketID() {
		return exchangeMarketID;
	}

	public void setExchangeMarketID(String exchangeMarketID) {
		this.exchangeMarketID = exchangeMarketID;
	}

	public String getMathematicOperatorCode() {
		return mathematicOperatorCode;
	}

	public void setMathematicOperatorCode(String mathematicOperatorCode) {
		this.mathematicOperatorCode = mathematicOperatorCode;
	}

	public BigDecimal getSourceCurrencyBaseRate() {
		return sourceCurrencyBaseRate;
	}

	public void setSourceCurrencyBaseRate(BigDecimal sourceCurrencyBaseRate) {
		this.sourceCurrencyBaseRate = sourceCurrencyBaseRate;
	}

	public String getSourceCurrencyCode() {
		return sourceCurrencyCode;
	}

	public void setSourceCurrencyCode(String sourceCurrencyCode) {
		this.sourceCurrencyCode = sourceCurrencyCode;
	}

	public BigDecimal getTargetCurrencyBaseRate() {
		return targetCurrencyBaseRate;
	}

	public void setTargetCurrencyBaseRate(BigDecimal targetCurrencyBaseRate) {
		this.targetCurrencyBaseRate = targetCurrencyBaseRate;
	}

	public String getTargetCurrencyCode() {
		return targetCurrencyCode;
	}

	public void setTargetCurrencyCode(String targetCurrencyCode) {
		this.targetCurrencyCode = targetCurrencyCode;
	}

	private Contract foreignExchangeContract;


}//end Exchange Rate
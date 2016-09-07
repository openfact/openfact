

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
	private Rate. Type CalculationRate;
	/**
	 * The date on which the exchange rate was established.
	 */
	private Date. Type Date;
	/**
	 * An identifier for the currency exchange market used as the source of this
	 * exchange rate.
	 */
	private Identifier. Type ExchangeMarketID;
	/**
	 * A code signifying whether the calculation rate is a multiplier or a divisor.
	 */
	private Operator_ Code. Type MathematicOperatorCode;
	/**
	 * In the case of a source currency with denominations of small value, the unit
	 * base.
	 */
	private Rate. Type SourceCurrencyBaseRate;
	/**
	 * The reference currency for this exchange rate; the currency from which the
	 * exchange is being made.
	 */
	private Currency_ Code. Type SourceCurrencyCode;
	/**
	 * In the case of a target currency with denominations of small value, the unit
	 * base.
	 */
	private Rate. Type TargetCurrencyBaseRate;
	/**
	 * The target currency for this exchange rate; the currency to which the exchange
	 * is being made.
	 */
	private Currency_ Code. Type TargetCurrencyCode;
	private Contract Foreign Exchange Contract;

	public Exchange Rate(){

	}

	public void finalize() throws Throwable {

	}
	public Rate. Type getCalculationRate(){
		return CalculationRate;
	}

	public Date. Type getDate(){
		return Date;
	}

	public Identifier. Type getExchangeMarketID(){
		return ExchangeMarketID;
	}

	public Contract getForeign Exchange Contract(){
		return Foreign Exchange Contract;
	}

	public Operator_ Code. Type getMathematicOperatorCode(){
		return MathematicOperatorCode;
	}

	public Rate. Type getSourceCurrencyBaseRate(){
		return SourceCurrencyBaseRate;
	}

	public Currency_ Code. Type getSourceCurrencyCode(){
		return SourceCurrencyCode;
	}

	public Rate. Type getTargetCurrencyBaseRate(){
		return TargetCurrencyBaseRate;
	}

	public Currency_ Code. Type getTargetCurrencyCode(){
		return TargetCurrencyCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationRate(Rate. Type newVal){
		CalculationRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDate(Date. Type newVal){
		Date = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExchangeMarketID(Identifier. Type newVal){
		ExchangeMarketID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForeign Exchange Contract(Contract newVal){
		Foreign Exchange Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMathematicOperatorCode(Operator_ Code. Type newVal){
		MathematicOperatorCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSourceCurrencyBaseRate(Rate. Type newVal){
		SourceCurrencyBaseRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSourceCurrencyCode(Currency_ Code. Type newVal){
		SourceCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTargetCurrencyBaseRate(Rate. Type newVal){
		TargetCurrencyBaseRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTargetCurrencyCode(Currency_ Code. Type newVal){
		TargetCurrencyCode = newVal;
	}
}//end Exchange Rate
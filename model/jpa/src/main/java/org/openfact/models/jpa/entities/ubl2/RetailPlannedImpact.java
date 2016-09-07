

/**
 * A class to describe a planned effect of a retail event (e.g., a promotion or a
 * change in inventory policy) upon supply or demand.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:35 a. m.
 */
public class RetailPlannedImpact {

	/**
	 * Estimated monetary value of the planned event as an impact
	 */
	private Amount. Type Amount;
	/**
	 * It will have impact on either Sales forecast or Order Forecast
	 */
	private Code. Type ForecastPurposeCode;
	/**
	 * A code signifying the type of forecast. Examples of values are: BASE
	 * PROMOTIONAL SEASONAL TOTAL
	 */
	private Code. Type ForecastTypeCode;
	private Period m_Period;

	public Retail Planned Impact(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAmount(){
		return Amount;
	}

	public Code. Type getForecastPurposeCode(){
		return ForecastPurposeCode;
	}

	public Code. Type getForecastTypeCode(){
		return ForecastTypeCode;
	}

	public Period getPeriod(){
		return m_Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(Amount. Type newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecastPurposeCode(Code. Type newVal){
		ForecastPurposeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecastTypeCode(Code. Type newVal){
		ForecastTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
	}
}//end Retail Planned Impact


/**
 * Establishes the criterion for one of the three types of exceptions. This class
 * provides criteria for the kind of forecast exception, the identification of the
 * purpose of the forecast, the source of data and the time basis criterion for
 * the exception.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:18 a. m.
 */
public class ForecastExceptionCriterionLine {

	/**
	 * If it is a forecast comparison exception, this value indicates the other source
	 * of information.
	 */
	private Code. Type ComparisonDataSourceCode;
	/**
	 * Indication of the partner who provides the information.
	 */
	private Code. Type DataSourceCode;
	/**
	 * A description of the purpose for the forecast that is assigned to each forecast
	 * data item exception criterion.
	 */
	private Code. Type ForecastPurposeCode;
	/**
	 * A description of a Forecast selected from a list.
	 */
	private Code. Type ForecastTypeCode;
	/**
	 * Time basis in days for the Exception.
	 */
	private Quantity. Type TimeDeltaDaysQuantity;

	public Forecast Exception Criterion Line(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getComparisonDataSourceCode(){
		return ComparisonDataSourceCode;
	}

	public Code. Type getDataSourceCode(){
		return DataSourceCode;
	}

	public Code. Type getForecastPurposeCode(){
		return ForecastPurposeCode;
	}

	public Code. Type getForecastTypeCode(){
		return ForecastTypeCode;
	}

	public Quantity. Type getTimeDeltaDaysQuantity(){
		return TimeDeltaDaysQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComparisonDataSourceCode(Code. Type newVal){
		ComparisonDataSourceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDataSourceCode(Code. Type newVal){
		DataSourceCode = newVal;
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
	public void setTimeDeltaDaysQuantity(Quantity. Type newVal){
		TimeDeltaDaysQuantity = newVal;
	}
}//end Forecast Exception Criterion Line
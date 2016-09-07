package org.openfact.models.jpa.entities.ubl;


/**
 * As explained in Exception Criteria Line: Three types of exception criteria can
 * be defined, Operational, Metric or Forecast Exceptions. This class provides
 * criteria for forecast exception type: the identification of the purpose of the
 * forecast, the source
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:16 a. m.
 */
public class ForecastException {

	/**
	 * A code signifying the partner providing the information in this forecast
	 * exception.
	 */
	private Code. Type ComparisonDataCode;
	/**
	 * The date on which this comparison forecast was issued.
	 */
	private Date. Type ComparisonForecastIssueDate;
	/**
	 * The time at which this comparison forecast was issued.
	 */
	private Time. Type ComparisonForecastIssueTime;
	/**
	 * A code signifying the partner who provides this information.
	 */
	private Code. Type DataSourceCode;
	/**
	 * It is either Sales forecast or Order Forecast. Definition can be changed like:
	 * "The purpose of the Forecast (either sales or order), about which an exception
	 * criteria is being defined".
	 */
	private Code. Type ForecastPurposeCode;
	/**
	 * A code signifying the type of forecast. Example of values are:BASE PROMOTIONAL
	 * SEASONAL TOTAL
	 */
	private Code. Type ForecastTypeCode;
	/**
	 * The date on which the forecast was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The time at which the forecast was issued.
	 */
	private Time. Type IssueTime;

	public Forecast Exception(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getComparisonDataCode(){
		return ComparisonDataCode;
	}

	public Date. Type getComparisonForecastIssueDate(){
		return ComparisonForecastIssueDate;
	}

	public Time. Type getComparisonForecastIssueTime(){
		return ComparisonForecastIssueTime;
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

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComparisonDataCode(Code. Type newVal){
		ComparisonDataCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComparisonForecastIssueDate(Date. Type newVal){
		ComparisonForecastIssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComparisonForecastIssueTime(Time. Type newVal){
		ComparisonForecastIssueTime = newVal;
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
	public void setIssueDate(Date. Type newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(Time. Type newVal){
		IssueTime = newVal;
	}
}//end Forecast Exception
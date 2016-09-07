package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

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
	private String ComparisonDataCode;
	/**
	 * The date on which this comparison forecast was issued.
	 */
	private LocalDate ComparisonForecastIssueDate;
	/**
	 * The time at which this comparison forecast was issued.
	 */
	private LocalTime ComparisonForecastIssueTime;
	/**
	 * A code signifying the partner who provides this information.
	 */
	private String DataSourceCode;
	/**
	 * It is either Sales forecast or Order Forecast. Definition can be changed like:
	 * "The purpose of the Forecast (either sales or order), about which an exception
	 * criteria is being defined".
	 */
	private String ForecastPurposeCode;
	/**
	 * A code signifying the type of forecast. Example of values are:BASE PROMOTIONAL
	 * SEASONAL TOTAL
	 */
	private String ForecastTypeCode;
	/**
	 * The date on which the forecast was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time at which the forecast was issued.
	 */
	private LocalTime IssueTime;

	public Forecast Exception(){

	}

	public void finalize() throws Throwable {

	}
	public String getComparisonDataCode(){
		return ComparisonDataCode;
	}

	public LocalDate getComparisonForecastIssueDate(){
		return ComparisonForecastIssueDate;
	}

	public LocalTime getComparisonForecastIssueTime(){
		return ComparisonForecastIssueTime;
	}

	public String getDataSourceCode(){
		return DataSourceCode;
	}

	public String getForecastPurposeCode(){
		return ForecastPurposeCode;
	}

	public String getForecastTypeCode(){
		return ForecastTypeCode;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComparisonDataCode(String newVal){
		ComparisonDataCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComparisonForecastIssueDate(LocalDate newVal){
		ComparisonForecastIssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComparisonForecastIssueTime(LocalTime newVal){
		ComparisonForecastIssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDataSourceCode(String newVal){
		DataSourceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecastPurposeCode(String newVal){
		ForecastPurposeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecastTypeCode(String newVal){
		ForecastTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal){
		IssueTime = newVal;
	}
}//end Forecast Exception
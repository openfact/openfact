package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * As explained in Exception Criteria Line: Three types of exception criteria
 * can be defined, Operational, Metric or Forecast Exceptions. This class
 * provides criteria for forecast exception type: the identification of the
 * purpose of the forecast, the source
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:16 a. m.
 */
public class ForecastException {

	/**
	 * A code signifying the partner providing the information in this forecast
	 * exception.
	 */
	private String comparisonDataCode;
	/**
	 * The date on which this comparison forecast was issued.
	 */
	private LocalDate comparisonForecastIssueDate;
	/**
	 * The time at which this comparison forecast was issued.
	 */
	private LocalTime comparisonForecastIssueTime;
	/**
	 * A code signifying the partner who provides this information.
	 */
	private String dataSourceCode;
	/**
	 * It is either Sales forecast or Order Forecast. Definition can be changed
	 * like: "The purpose of the Forecast (either sales or order), about which
	 * an exception criteria is being defined".
	 */
	private String forecastPurposeCode;
	/**
	 * A code signifying the type of forecast. Example of values are:BASE
	 * PROMOTIONAL SEASONAL TOTAL
	 */
	private String forecastTypeCode;
	/**
	 * The date on which the forecast was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time at which the forecast was issued.
	 */
	private LocalTime issueTime;

	public ForecastException() {

	}

	public void finalize() throws Throwable {

	}

	public String getComparisonDataCode() {
		return comparisonDataCode;
	}

	public void setComparisonDataCode(String comparisonDataCode) {
		this.comparisonDataCode = comparisonDataCode;
	}

	public LocalDate getComparisonForecastIssueDate() {
		return comparisonForecastIssueDate;
	}

	public void setComparisonForecastIssueDate(LocalDate comparisonForecastIssueDate) {
		this.comparisonForecastIssueDate = comparisonForecastIssueDate;
	}

	public LocalTime getComparisonForecastIssueTime() {
		return comparisonForecastIssueTime;
	}

	public void setComparisonForecastIssueTime(LocalTime comparisonForecastIssueTime) {
		this.comparisonForecastIssueTime = comparisonForecastIssueTime;
	}

	public String getDataSourceCode() {
		return dataSourceCode;
	}

	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}

	public String getForecastPurposeCode() {
		return forecastPurposeCode;
	}

	public void setForecastPurposeCode(String forecastPurposeCode) {
		this.forecastPurposeCode = forecastPurposeCode;
	}

	public String getForecastTypeCode() {
		return forecastTypeCode;
	}

	public void setForecastTypeCode(String forecastTypeCode) {
		this.forecastTypeCode = forecastTypeCode;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalTime getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		this.issueTime = issueTime;
	}
}// end Forecast Exception
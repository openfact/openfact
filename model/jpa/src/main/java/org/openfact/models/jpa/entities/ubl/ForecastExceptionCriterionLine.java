package org.openfact.models.jpa.entities.ubl;


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
	private String ComparisonDataSourceCode;
	/**
	 * Indication of the partner who provides the information.
	 */
	private String DataSourceCode;
	/**
	 * A description of the purpose for the forecast that is assigned to each forecast
	 * data item exception criterion.
	 */
	private String ForecastPurposeCode;
	/**
	 * A description of a Forecast selected from a list.
	 */
	private String ForecastTypeCode;
	/**
	 * Time basis in days for the Exception.
	 */
	private BigDecimal TimeDeltaDaysQuantity;

	public Forecast Exception Criterion Line(){

	}

	public void finalize() throws Throwable {

	}
	public String getComparisonDataSourceCode(){
		return ComparisonDataSourceCode;
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

	public BigDecimal getTimeDeltaDaysQuantity(){
		return TimeDeltaDaysQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComparisonDataSourceCode(String newVal){
		ComparisonDataSourceCode = newVal;
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
	public void setTimeDeltaDaysQuantity(BigDecimal newVal){
		TimeDeltaDaysQuantity = newVal;
	}
}//end Forecast Exception Criterion Line
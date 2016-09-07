package org.openfact.models.jpa.entities.ubl;


/**
 * Detailed information about a particular Forecast Line within a Forecast
 * Document
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:19 a. m.
 */
public class ForecastLine {

	/**
	 * A code signifying the type of forecast. Examples: BASE PROMOTIONAL SEASONAL
	 * TOTAL
	 */
	private String ForecastTypeCode;
	/**
	 * An indicator that the status of the forecast is modifiable (true) or not
	 * (false).
	 */
	private boolean FrozenDocumentIndicator;
	/**
	 * An identifier for this forecast line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	private Period Forecast Period;
	private Sales Item m_Sales Item;

	public Forecast Line(){

	}

	public void finalize() throws Throwable {

	}
	public Period getForecast Period(){
		return Forecast Period;
	}

	public String getForecastTypeCode(){
		return ForecastTypeCode;
	}

	public boolean getFrozenDocumentIndicator(){
		return FrozenDocumentIndicator;
	}

	public String getID(){
		return ID;
	}

	public String getNote(){
		return Note;
	}

	public Sales Item getSales Item(){
		return m_Sales Item;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecast Period(Period newVal){
		Forecast Period = newVal;
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
	public void setFrozenDocumentIndicator(boolean newVal){
		FrozenDocumentIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSales Item(Sales Item newVal){
		m_Sales Item = newVal;
	}
}//end Forecast Line
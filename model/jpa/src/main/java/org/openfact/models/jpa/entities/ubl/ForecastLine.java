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
	private Code. Type ForecastTypeCode;
	/**
	 * An indicator that the status of the forecast is modifiable (true) or not
	 * (false).
	 */
	private Indicator. Type FrozenDocumentIndicator;
	/**
	 * An identifier for this forecast line.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	private Period Forecast Period;
	private Sales Item m_Sales Item;

	public Forecast Line(){

	}

	public void finalize() throws Throwable {

	}
	public Period getForecast Period(){
		return Forecast Period;
	}

	public Code. Type getForecastTypeCode(){
		return ForecastTypeCode;
	}

	public Indicator. Type getFrozenDocumentIndicator(){
		return FrozenDocumentIndicator;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getNote(){
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
	public void setForecastTypeCode(Code. Type newVal){
		ForecastTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFrozenDocumentIndicator(Indicator. Type newVal){
		FrozenDocumentIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(Text. Type newVal){
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
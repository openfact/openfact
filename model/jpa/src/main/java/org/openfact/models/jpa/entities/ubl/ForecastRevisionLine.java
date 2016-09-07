package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Forecast Revision describing a revision to a line
 * in a Forecast.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:21 a. m.
 */
public class ForecastRevisionLine {

	/**
	 * A code signifying the reason for the adjustment specified in this forecast
	 * revision line.
	 */
	private Code. Type AdjustmentReasonCode;
	/**
	 * Text describing the revision to this line.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this forecast revision line.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * An identifier for the revised forecast line.
	 */
	private Identifier. Type RevisedForecastLineID;
	/**
	 * The date on which the forecast modified by this revision was generated or
	 * created.
	 */
	private Date. Type SourceForecastIssueDate;
	/**
	 * The time at which the forecast modified by this revision was generated or
	 * created.
	 */
	private Time. Type SourceForecastIssueTime;
	private Period Forecast Period;
	private Sales Item m_Sales Item;

	public Forecast Revision Line(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getAdjustmentReasonCode(){
		return AdjustmentReasonCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Period getForecast Period(){
		return Forecast Period;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Identifier. Type getRevisedForecastLineID(){
		return RevisedForecastLineID;
	}

	public Sales Item getSales Item(){
		return m_Sales Item;
	}

	public Date. Type getSourceForecastIssueDate(){
		return SourceForecastIssueDate;
	}

	public Time. Type getSourceForecastIssueTime(){
		return SourceForecastIssueTime;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdjustmentReasonCode(Code. Type newVal){
		AdjustmentReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
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
	public void setRevisedForecastLineID(Identifier. Type newVal){
		RevisedForecastLineID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSales Item(Sales Item newVal){
		m_Sales Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSourceForecastIssueDate(Date. Type newVal){
		SourceForecastIssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSourceForecastIssueTime(Time. Type newVal){
		SourceForecastIssueTime = newVal;
	}
}//end Forecast Revision Line
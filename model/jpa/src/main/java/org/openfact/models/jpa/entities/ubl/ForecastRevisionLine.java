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
	private String AdjustmentReasonCode;
	/**
	 * Text describing the revision to this line.
	 */
	private String Description;
	/**
	 * An identifier for this forecast revision line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * An identifier for the revised forecast line.
	 */
	private String RevisedForecastLineID;
	/**
	 * The date on which the forecast modified by this revision was generated or
	 * created.
	 */
	private LocalDate SourceForecastIssueDate;
	/**
	 * The time at which the forecast modified by this revision was generated or
	 * created.
	 */
	private LocalTime SourceForecastIssueTime;
	private Period Forecast Period;
	private Sales Item m_Sales Item;

	public Forecast Revision Line(){

	}

	public void finalize() throws Throwable {

	}
	public String getAdjustmentReasonCode(){
		return AdjustmentReasonCode;
	}

	public String getDescription(){
		return Description;
	}

	public Period getForecast Period(){
		return Forecast Period;
	}

	public String getID(){
		return ID;
	}

	public String getNote(){
		return Note;
	}

	public String getRevisedForecastLineID(){
		return RevisedForecastLineID;
	}

	public Sales Item getSales Item(){
		return m_Sales Item;
	}

	public LocalDate getSourceForecastIssueDate(){
		return SourceForecastIssueDate;
	}

	public LocalTime getSourceForecastIssueTime(){
		return SourceForecastIssueTime;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdjustmentReasonCode(String newVal){
		AdjustmentReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
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
	public void setRevisedForecastLineID(String newVal){
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
	public void setSourceForecastIssueDate(LocalDate newVal){
		SourceForecastIssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSourceForecastIssueTime(LocalTime newVal){
		SourceForecastIssueTime = newVal;
	}
}//end Forecast Revision Line
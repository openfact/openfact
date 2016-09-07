package org.openfact.models.jpa.entities.ubl;


import java.time.LocalDate;
import java.time.LocalTime;

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
	private String adjustmentReasonCode;
	/**
	 * Text describing the revision to this line.
	 */
	private String description;
	/**
	 * An identifier for this forecast revision line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String note;
	/**
	 * An identifier for the revised forecast line.
	 */
	private String revisedForecastLineID;
	/**
	 * The date on which the forecast modified by this revision was generated or
	 * created.
	 */
	private LocalDate sourceForecastIssueDate;
	/**
	 * The time at which the forecast modified by this revision was generated or
	 * created.
	 */
	private LocalTime sourceForecastIssueTime;
	private Period forecastPeriod;
	private SalesItem m_SalesItem;

	public ForecastRevisionLine(){

	}

	public void finalize() throws Throwable {

	}

	public String getAdjustmentReasonCode() {
		return adjustmentReasonCode;
	}

	public void setAdjustmentReasonCode(String adjustmentReasonCode) {
		this.adjustmentReasonCode = adjustmentReasonCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRevisedForecastLineID() {
		return revisedForecastLineID;
	}

	public void setRevisedForecastLineID(String revisedForecastLineID) {
		this.revisedForecastLineID = revisedForecastLineID;
	}

	public LocalDate getSourceForecastIssueDate() {
		return sourceForecastIssueDate;
	}

	public void setSourceForecastIssueDate(LocalDate sourceForecastIssueDate) {
		this.sourceForecastIssueDate = sourceForecastIssueDate;
	}

	public LocalTime getSourceForecastIssueTime() {
		return sourceForecastIssueTime;
	}

	public void setSourceForecastIssueTime(LocalTime sourceForecastIssueTime) {
		this.sourceForecastIssueTime = sourceForecastIssueTime;
	}

	public Period getForecastPeriod() {
		return forecastPeriod;
	}

	public void setForecastPeriod(Period forecastPeriod) {
		this.forecastPeriod = forecastPeriod;
	}

	public SalesItem getM_SalesItem() {
		return m_SalesItem;
	}

	public void setM_SalesItem(SalesItem m_SalesItem) {
		this.m_SalesItem = m_SalesItem;
	}
}//end Forecast Revision Line
package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * Detailed information about a particular Forecast Line within a Forecast
 * Document
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:19 a. m.
 */
public class ForecastLine {

	/**
	 * A code signifying the type of forecast. Examples: BASE PROMOTIONAL
	 * SEASONAL TOTAL
	 */
	private String forecastTypeCode;
	/**
	 * An indicator that the status of the forecast is modifiable (true) or not
	 * (false).
	 */
	private boolean frozenDocumentIndicator;
	/**
	 * An identifier for this forecast line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	private Period forecastPeriod;
	private List<SalesItem> salesItems=new ArrayList<>();

	public ForecastLine() {

	}

	public void finalize() throws Throwable {

	}

	public String getForecastTypeCode() {
		return forecastTypeCode;
	}

	public void setForecastTypeCode(String forecastTypeCode) {
		this.forecastTypeCode = forecastTypeCode;
	}

	public boolean isFrozenDocumentIndicator() {
		return frozenDocumentIndicator;
	}

	public void setFrozenDocumentIndicator(boolean frozenDocumentIndicator) {
		this.frozenDocumentIndicator = frozenDocumentIndicator;
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

	public Period getForecastPeriod() {
		return forecastPeriod;
	}

	public void setForecastPeriod(Period forecastPeriod) {
		this.forecastPeriod = forecastPeriod;
	}

	public List<SalesItem> getSalesItems() {
		return salesItems;
	}

	public void setSalesItems(List<SalesItem> salesItems) {
		this.salesItems = salesItems;
	}
}// end Forecast Line
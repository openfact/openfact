package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Performance History.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:42 a. m.
 */
public class PerformanceDataLine {

	/**
	 * An identifier for this performance data line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * A code signifying the measure of performance applicable to the reported
	 * attribute.
	 */
	private String performanceMetricTypeCode;
	/**
	 * The value of the reported attribute.
	 */
	private BigDecimal performanceValueQuantity;
	private List<Item> items = new ArrayList<>();
	private List<Period> periods = new ArrayList<>();

	public PerformanceDataLine() {

	}

	public void finalize() throws Throwable {

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

	public String getPerformanceMetricTypeCode() {
		return performanceMetricTypeCode;
	}

	public void setPerformanceMetricTypeCode(String performanceMetricTypeCode) {
		this.performanceMetricTypeCode = performanceMetricTypeCode;
	}

	public BigDecimal getPerformanceValueQuantity() {
		return performanceValueQuantity;
	}

	public void setPerformanceValueQuantity(BigDecimal performanceValueQuantity) {
		this.performanceValueQuantity = performanceValueQuantity;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
}// end Performance Data Line
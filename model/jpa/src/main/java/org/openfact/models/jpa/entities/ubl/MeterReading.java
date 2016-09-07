package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to describe a meter reading.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:09 a. m.
 */
public class MeterReading {

	/**
	 * Consumption in the period from PreviousMeterReadingDate to
	 * LatestMeterReadingDate.
	 */
	private BigDecimal deliveredQuantity;
	/**
	 * An identifier for this meter reading.
	 */
	private String id;
	/**
	 * The quantity of the latest meter reading.
	 */
	private BigDecimal latestMeterQuantity;
	/**
	 * The date of the latest meter reading.
	 */
	private LocalDate latestMeterReadingDate;
	/**
	 * The method used for the latest meter reading, expressed as text.
	 */
	private String latestMeterReadingMethod;
	/**
	 * The method used for the latest meter reading, expressed as a code.
	 */
	private String latestMeterReadingMethodCode;
	/**
	 * Text containing comments on this meter reading.
	 */
	private String meterReadingComments;
	/**
	 * The type of this meter reading, expressed as text.
	 */
	private String meterReadingType;
	/**
	 * The type of this meter reading, expressed as a code.
	 */
	private String meterReadingTypeCode;
	/**
	 * The quantity of the previous meter reading.
	 */
	private BigDecimal previousMeterQuantity;
	/**
	 * The date of the previous meter reading.
	 */
	private LocalDate previousMeterReadingDate;
	/**
	 * The method used for the previous meter reading, expressed as text.
	 */
	private String previousMeterReadingMethod;
	/**
	 * The method used for the previous meter reading, expressed as a code.
	 */
	private String previousMeterReadingMethodCode;

	public MeterReading() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getDeliveredQuantity() {
		return deliveredQuantity;
	}

	public void setDeliveredQuantity(BigDecimal deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getLatestMeterQuantity() {
		return latestMeterQuantity;
	}

	public void setLatestMeterQuantity(BigDecimal latestMeterQuantity) {
		this.latestMeterQuantity = latestMeterQuantity;
	}

	public LocalDate getLatestMeterReadingDate() {
		return latestMeterReadingDate;
	}

	public void setLatestMeterReadingDate(LocalDate latestMeterReadingDate) {
		this.latestMeterReadingDate = latestMeterReadingDate;
	}

	public String getLatestMeterReadingMethod() {
		return latestMeterReadingMethod;
	}

	public void setLatestMeterReadingMethod(String latestMeterReadingMethod) {
		this.latestMeterReadingMethod = latestMeterReadingMethod;
	}

	public String getLatestMeterReadingMethodCode() {
		return latestMeterReadingMethodCode;
	}

	public void setLatestMeterReadingMethodCode(String latestMeterReadingMethodCode) {
		this.latestMeterReadingMethodCode = latestMeterReadingMethodCode;
	}

	public String getMeterReadingComments() {
		return meterReadingComments;
	}

	public void setMeterReadingComments(String meterReadingComments) {
		this.meterReadingComments = meterReadingComments;
	}

	public String getMeterReadingType() {
		return meterReadingType;
	}

	public void setMeterReadingType(String meterReadingType) {
		this.meterReadingType = meterReadingType;
	}

	public String getMeterReadingTypeCode() {
		return meterReadingTypeCode;
	}

	public void setMeterReadingTypeCode(String meterReadingTypeCode) {
		this.meterReadingTypeCode = meterReadingTypeCode;
	}

	public BigDecimal getPreviousMeterQuantity() {
		return previousMeterQuantity;
	}

	public void setPreviousMeterQuantity(BigDecimal previousMeterQuantity) {
		this.previousMeterQuantity = previousMeterQuantity;
	}

	public LocalDate getPreviousMeterReadingDate() {
		return previousMeterReadingDate;
	}

	public void setPreviousMeterReadingDate(LocalDate previousMeterReadingDate) {
		this.previousMeterReadingDate = previousMeterReadingDate;
	}

	public String getPreviousMeterReadingMethod() {
		return previousMeterReadingMethod;
	}

	public void setPreviousMeterReadingMethod(String previousMeterReadingMethod) {
		this.previousMeterReadingMethod = previousMeterReadingMethod;
	}

	public String getPreviousMeterReadingMethodCode() {
		return previousMeterReadingMethodCode;
	}

	public void setPreviousMeterReadingMethodCode(String previousMeterReadingMethodCode) {
		this.previousMeterReadingMethodCode = previousMeterReadingMethodCode;
	}
}// end Meter Reading
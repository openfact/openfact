package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a period of time.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:45 a. m.
 */
public class Period {

	/**
	 * A description of this period, expressed as text.
	 */
	private String description;
	/**
	 * A description of this period, expressed as a code.
	 */
	private String descriptionCode;
	/**
	 * The duration of this period, expressed as an ISO 8601 code.
	 */
	private BigDecimal durationMeasure;
	/**
	 * The date on which this period ends.
	 */
	private LocalDate endDate;
	/**
	 * The time at which this period ends.
	 */
	private LocalTime endTime;
	/**
	 * The date on which this period begins.
	 */
	private LocalDate startDate;
	/**
	 * The time at which this period begins.
	 */
	private LocalTime startTime;

	public Period() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionCode() {
		return descriptionCode;
	}

	public void setDescriptionCode(String descriptionCode) {
		this.descriptionCode = descriptionCode;
	}

	public BigDecimal getDurationMeasure() {
		return durationMeasure;
	}

	public void setDurationMeasure(BigDecimal durationMeasure) {
		this.durationMeasure = durationMeasure;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
}// end Period
package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:33 a. m.
 */
public class Payment {

	/**
	 * An identifier for this payment.
	 */
	private String id;
	/**
	 * An identifier for the payment instruction.
	 */
	private String instructionID;
	/**
	 * The amount of this payment.
	 */
	private BigDecimal paidAmount;
	/**
	 * The date on which this payment was made.
	 */
	private LocalDate paidDate;
	/**
	 * The time at which this payment was made.
	 */
	private LocalTime paidTime;
	/**
	 * The date on which this payment was received.
	 */
	private LocalDate receivedDate;

	public Payment() {

	}

	public void finalize() throws Throwable {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstructionID() {
		return instructionID;
	}

	public void setInstructionID(String instructionID) {
		this.instructionID = instructionID;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	public LocalTime getPaidTime() {
		return paidTime;
	}

	public void setPaidTime(LocalTime paidTime) {
		this.paidTime = paidTime;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}
}// end Payment
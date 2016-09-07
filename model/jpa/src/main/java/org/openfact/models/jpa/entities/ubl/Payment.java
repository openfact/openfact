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
	private String ID;
	/**
	 * An identifier for the payment instruction.
	 */
	private String InstructionID;
	/**
	 * The amount of this payment.
	 */
	private BigDecimal PaidAmount;
	/**
	 * The date on which this payment was made.
	 */
	private LocalDate PaidDate;
	/**
	 * The time at which this payment was made.
	 */
	private LocalTime PaidTime;
	/**
	 * The date on which this payment was received.
	 */
	private LocalDate ReceivedDate;

	public Payment() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public String getInstructionID() {
		return InstructionID;
	}

	public BigDecimal getPaidAmount() {
		return PaidAmount;
	}

	public LocalDate getPaidDate() {
		return PaidDate;
	}

	public LocalTime getPaidTime() {
		return PaidTime;
	}

	public LocalDate getReceivedDate() {
		return ReceivedDate;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInstructionID(String newVal) {
		InstructionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaidAmount(BigDecimal newVal) {
		PaidAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaidDate(LocalDate newVal) {
		PaidDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaidTime(LocalTime newVal) {
		PaidTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedDate(LocalDate newVal) {
		ReceivedDate = newVal;
	}
}// end Payment
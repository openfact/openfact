package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to describe a payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:33 a. m.
 */
public class Payment {

	/**
	 * An identifier for this payment.
	 */
	private Identifier. Type ID;
	/**
	 * An identifier for the payment instruction.
	 */
	private Identifier. Type InstructionID;
	/**
	 * The amount of this payment.
	 */
	private Amount. Type PaidAmount;
	/**
	 * The date on which this payment was made.
	 */
	private Date. Type PaidDate;
	/**
	 * The time at which this payment was made.
	 */
	private Time. Type PaidTime;
	/**
	 * The date on which this payment was received.
	 */
	private Date. Type ReceivedDate;

	public Payment(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Identifier. Type getInstructionID(){
		return InstructionID;
	}

	public Amount. Type getPaidAmount(){
		return PaidAmount;
	}

	public Date. Type getPaidDate(){
		return PaidDate;
	}

	public Time. Type getPaidTime(){
		return PaidTime;
	}

	public Date. Type getReceivedDate(){
		return ReceivedDate;
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
	public void setInstructionID(Identifier. Type newVal){
		InstructionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaidAmount(Amount. Type newVal){
		PaidAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaidDate(Date. Type newVal){
		PaidDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaidTime(Time. Type newVal){
		PaidTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceivedDate(Date. Type newVal){
		ReceivedDate = newVal;
	}
}//end Payment
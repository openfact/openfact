package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a justification for the choice of tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:02 a. m.
 */
public class ProcessJustification {

	/**
	 * Text providing justification for the selection of this process.
	 */
	private String Description;
	/**
	 * A code signifying the type of the previous tendering process (which is
	 * now being cancelled).
	 */
	private String PreviousCancellationReasonCode;
	/**
	 * The reason why the contracting authority has followed a particular
	 * tendering procedure for the awarding of a contract, expressed as text.
	 */
	private String ProcessReason;
	/**
	 * The reason why the contracting authority has followed a particular
	 * tendering procedure for the awarding of a contract, expressed as a code.
	 */
	private String ProcessReasonCode;

	public ProcessJustification() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return Description;
	}

	public String getPreviousCancellationReasonCode() {
		return PreviousCancellationReasonCode;
	}

	public String getProcessReason() {
		return ProcessReason;
	}

	public String getProcessReasonCode() {
		return ProcessReasonCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousCancellationReasonCode(String newVal) {
		PreviousCancellationReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcessReason(String newVal) {
		ProcessReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcessReasonCode(String newVal) {
		ProcessReasonCode = newVal;
	}
}// end ProcessJustification
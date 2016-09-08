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
	private String description;
	/**
	 * A code signifying the type of the previous tendering process (which is
	 * now being cancelled).
	 */
	private String previousCancellationReasonCode;
	/**
	 * The reason why the contracting authority has followed a particular
	 * tendering procedure for the awarding of a contract, expressed as text.
	 */
	private String processReason;
	/**
	 * The reason why the contracting authority has followed a particular
	 * tendering procedure for the awarding of a contract, expressed as a code.
	 */
	private String processReasonCode;

	public ProcessJustification() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreviousCancellationReasonCode() {
		return previousCancellationReasonCode;
	}

	public void setPreviousCancellationReasonCode(String previousCancellationReasonCode) {
		this.previousCancellationReasonCode = previousCancellationReasonCode;
	}

	public String getProcessReason() {
		return processReason;
	}

	public void setProcessReason(String processReason) {
		this.processReason = processReason;
	}

	public String getProcessReasonCode() {
		return processReasonCode;
	}

	public void setProcessReasonCode(String processReasonCode) {
		this.processReasonCode = processReasonCode;
	}
}// end ProcessJustification
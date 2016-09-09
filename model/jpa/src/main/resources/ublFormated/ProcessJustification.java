package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a justification for the choice of tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:02 a. m.
 */
public class ProcessJustification{

	/**
	 * Text providing justification for the selection of this process.
	 */
	private TextType Description;
	/**
	 * A code signifying the type of the previous tendering process (which is now
	 * being cancelled).
	 */
	private CodeType PreviousCancellationReasonCode;
	/**
	 * The reason why the contracting authority has followed a particular tendering
	 * procedure for the awarding of a contract, expressed as text.
	 */
	private TextType ProcessReason;
	/**
	 * The reason why the contracting authority has followed a particular tendering
	 * procedure for the awarding of a contract, expressed as a code.
	 */
	private CodeType ProcessReasonCode;

}

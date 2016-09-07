

/**
 * A class to describe a justification for the choice of tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:02 a. m.
 */
public class Process Justification {

	/**
	 * Text providing justification for the selection of this process.
	 */
	private Text. Type Description;
	/**
	 * A code signifying the type of the previous tendering process (which is now
	 * being cancelled).
	 */
	private Code. Type PreviousCancellationReasonCode;
	/**
	 * The reason why the contracting authority has followed a particular tendering
	 * procedure for the awarding of a contract, expressed as text.
	 */
	private Text. Type ProcessReason;
	/**
	 * The reason why the contracting authority has followed a particular tendering
	 * procedure for the awarding of a contract, expressed as a code.
	 */
	private Code. Type ProcessReasonCode;

	public Process Justification(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Code. Type getPreviousCancellationReasonCode(){
		return PreviousCancellationReasonCode;
	}

	public Text. Type getProcessReason(){
		return ProcessReason;
	}

	public Code. Type getProcessReasonCode(){
		return ProcessReasonCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousCancellationReasonCode(Code. Type newVal){
		PreviousCancellationReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcessReason(Text. Type newVal){
		ProcessReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcessReasonCode(Code. Type newVal){
		ProcessReasonCode = newVal;
	}
}//end Process Justification
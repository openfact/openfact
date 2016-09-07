

/**
 * A class that refers to a phase of work. Used for instance to specify what part
 * of the contract the billing is referring to.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:01 a. m.
 */
public class Work Phase Reference {

	/**
	 * The date on which this phase of work ends.
	 */
	private Date. Type EndDate;
	/**
	 * An identifier for this phase of work.
	 */
	private Identifier. Type ID;
	/**
	 * The progress percentage of the work phase.
	 */
	private Percent. Type ProgressPercent;
	/**
	 * The date on which this phase of work begins.
	 */
	private Date. Type StartDate;
	/**
	 * Text describing this phase of work.
	 */
	private Text. Type WorkPhase;
	/**
	 * A code signifying this phase of work.
	 */
	private Code. Type WorkPhaseCode;
	private Document Reference Work Order Document Reference;

	public Work Phase Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Date. Type getEndDate(){
		return EndDate;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Percent. Type getProgressPercent(){
		return ProgressPercent;
	}

	public Date. Type getStartDate(){
		return StartDate;
	}

	public Document Reference getWork Order Document Reference(){
		return Work Order Document Reference;
	}

	public Text. Type getWorkPhase(){
		return WorkPhase;
	}

	public Code. Type getWorkPhaseCode(){
		return WorkPhaseCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEndDate(Date. Type newVal){
		EndDate = newVal;
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
	public void setProgressPercent(Percent. Type newVal){
		ProgressPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStartDate(Date. Type newVal){
		StartDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWork Order Document Reference(Document Reference newVal){
		Work Order Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWorkPhase(Text. Type newVal){
		WorkPhase = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWorkPhaseCode(Code. Type newVal){
		WorkPhaseCode = newVal;
	}
}//end Work Phase Reference